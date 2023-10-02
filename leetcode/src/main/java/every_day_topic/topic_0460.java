package every_day_topic;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class topic_0460 {

    private static class LFUCache {

        private final Map<Integer, Integer> CACHE;
        private final int capacity;
        private int currCapacity;
        private final Map<Integer, List<Long>> STRATEGY;

        private final Integer TIMESTAMP = 0;
        private final Integer COUNT = 1;


        public LFUCache(int capacity) {
            CACHE = new HashMap<>(capacity);
            STRATEGY = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public synchronized int get(int key) {
            Integer value = CACHE.get(key);
            if (value == null) {
                return -1;
            }
            List<Long> strategy = STRATEGY.get(key);
            strategy.set(TIMESTAMP, System.currentTimeMillis());
            Long usageCount = strategy.get(COUNT);
            usageCount++;
            strategy.set(COUNT, usageCount);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return value;
        }


        public synchronized void put(int key, int value) {
            Integer valueByKey = CACHE.get(key);
            long minCount = Integer.MAX_VALUE;
            ArrayList<Integer> minKeys = new ArrayList<>();
            if (valueByKey == null && currCapacity >= capacity) {
                for (Integer integer : STRATEGY.keySet()) {
                    List<Long> usage = STRATEGY.get(integer);
                    if (usage.get(COUNT) < minCount) {
                        minKeys.clear();
                        minKeys.add(integer);
                        minCount = usage.get(COUNT);
                    } else if (usage.get(COUNT) == minCount) {
                        minKeys.add(integer);
                    }
                }

                long minTime = Long.MAX_VALUE;
                int minTimeIndex = 0;
                for (Integer minKey : minKeys) {
                    if (STRATEGY.get(minKey).get(TIMESTAMP) < minTime) {
                        minTimeIndex = minKey;
                        minTime = STRATEGY.get(minKey).get(TIMESTAMP);
                    }
                }

                CACHE.remove(minTimeIndex);
                STRATEGY.remove(minTimeIndex);

                CACHE.put(key, value);
                List<Long> usage = new ArrayList<>(2);
                usage.add(System.currentTimeMillis());
                usage.add(0L);
                currCapacity++;
                STRATEGY.put(key, usage);
                return;
            }

            CACHE.put(key, value);
            if (valueByKey == null) {
                ArrayList<Long> usage = new ArrayList<>();
                usage.add(System.currentTimeMillis());
                usage.add(0L);
                STRATEGY.put(key, usage);
                currCapacity++;
            } else {
                List<Long> usage = STRATEGY.get(key);
                usage.set(TIMESTAMP, System.currentTimeMillis());
                Long useCount = usage.get(COUNT);
                useCount++;
                usage.set(COUNT, useCount);
            }
        }

        @SuppressWarnings("unused")
        static class Batter {

            private final int capacity;
            private int timeStamp;
            private final Map<Integer, Node> CACHE;
            private final TreeSet<Node> SORTED_NODE_SET;

            public Batter(int capacity) {
                this.capacity = capacity;
                this.timeStamp = 0;
                CACHE = new HashMap<>();
                SORTED_NODE_SET = new TreeSet<>();
            }

            public int get(int key) {
                if (capacity == 0) {
                    return -1;
                }

                if (!CACHE.containsKey(key)) {
                    return -1;
                }

                Node cache = CACHE.get(key);
                SORTED_NODE_SET.remove(cache);
                cache.count += 1;
                cache.timeStamp = ++timeStamp;
                SORTED_NODE_SET.add(cache);

                CACHE.put(key, cache);

                return cache.value;
            }

            public void put(int key, int value) {
                if (capacity == 0) {
                    return;
                }
                if (!CACHE.containsKey(key)) {
                    if (CACHE.size() == capacity) {
                        CACHE.remove(SORTED_NODE_SET.first().key);
                        SORTED_NODE_SET.remove(SORTED_NODE_SET.first());
                    }
                    Node cache = new Node(1, ++timeStamp, key, value);
                    CACHE.put(key, cache);
                    SORTED_NODE_SET.add(cache);
                } else {
                    // 这里和 get() 函数类似
                    Node cache = CACHE.get(key);
                    SORTED_NODE_SET.remove(cache);
                    cache.count += 1;
                    cache.timeStamp = ++timeStamp;
                    cache.value = value;
                    SORTED_NODE_SET.add(cache);
                    CACHE.put(key, cache);
                }
            }
        }

        static class Node implements Comparable<Node> {
            private int count;
            private int timeStamp;
            private final int key;
            private int value;

            Node(int count, int timeStamp, int key, int value) {
                this.count = count;
                this.timeStamp = timeStamp;
                this.key = key;
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }

                if (obj instanceof Node) {
                    Node newNode = (Node) obj;
                    return this.count == newNode.count && this.timeStamp == newNode.timeStamp;
                }

                return false;
            }

            @Override
            public int compareTo(Node newNode) {
                return count == newNode.count ?
                        timeStamp - newNode.timeStamp :
                        count - newNode.count;
            }

            @Override
            public int hashCode() {
                return count * 1000000007 + timeStamp;
            }
        }
    }
}