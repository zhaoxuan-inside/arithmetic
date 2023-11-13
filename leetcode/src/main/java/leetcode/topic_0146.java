package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0146 {

    private static class LRUCache {

        private final Map<Integer, Integer> cache;
        private final int length;
        private final Queue<Integer> TIMESTAMP;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            TIMESTAMP = new ArrayDeque<>(capacity);
            length = capacity;
        }

        public synchronized int get(int key) {
            Integer value = cache.get(key);
            if (value != null) {
                TIMESTAMP.remove(key);
                TIMESTAMP.offer(key);
                return value;
            }
            return -1;
        }

        public synchronized void put(int key, int value) {

            Integer integer = cache.get(key);
            if (integer != null) {
                cache.put(key, value);
                TIMESTAMP.remove(key);
                TIMESTAMP.offer(key);
                return;
            }

            if (TIMESTAMP.size() >= length) {
                Integer poll = TIMESTAMP.poll();
                cache.remove(poll);
            }
            cache.put(key, value);
            TIMESTAMP.offer(key);
        }
    }

}
