package every_day_topic;

import java.util.*;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class topic_2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int[] ans = new int[people.length];

        for (int index = 0; index < people.length; index++) {
            for (int[] flower : flowers) {
                int start = flower[0];
                int end = flower[1];

                if (people[index] >= start && people[index] <= end) {
                    ans[index]++;
                }
            }
        }

        return ans;
    }

    private static class Official {
        public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
            TreeMap<Integer, Integer> cnt = new TreeMap<>();
            for (int[] flower : flowers) {
                cnt.put(flower[0], cnt.getOrDefault(flower[0], 0) + 1);
                cnt.put(flower[1] + 1, cnt.getOrDefault(flower[1] + 1, 0) - 1);
            }
            int m = persons.length;
            Integer[] indices = IntStream.range(0, m).boxed().toArray(Integer[]::new);
            Arrays.sort(indices, Comparator.comparingInt(i -> persons[i]));
            int[] ans = new int[m];
            int curr = 0;
            for (int x : indices) {
                while (!cnt.isEmpty() && cnt.firstKey() <= persons[x]) {
                    curr += cnt.pollFirstEntry().getValue();
                }
                ans[x] = curr;
            }
            return ans;
        }
    }

    private static class Batter {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {

            int flowerCount = flowers.length;

            int[] starts = new int[flowerCount];
            int[] ends = new int[flowerCount];

            for (int index = 0; index < flowerCount; index++) {
                int[] flower = flowers[index];
                starts[index] = flower[0];
                ends[index] = flower[1];
            }

            Arrays.sort(starts);
            Arrays.sort(ends);

            int peopleCount = people.length;

            int[] result = new int[peopleCount];

            for (int index = 0; index < peopleCount; index++) {
                int open, close, arrival = people[index];

                if (arrival < starts[0]) {
                    open = 0;
                } else if (arrival >= starts[flowerCount - 1]) {
                    open = flowerCount;
                } else {
                    int left = 0;
                    int right = flowerCount - 1;

                    while (left < right) {
                        int mid = (left + right + 1) >> 1;
                        if (starts[mid] <= arrival) {
                            left = mid;
                        } else {
                            right = mid - 1;
                        }
                    }
                    open = left + 1;
                }
                if (arrival <= ends[0]) {
                    close = 0;
                } else if (arrival > ends[flowerCount - 1]) {
                    close = flowerCount;
                } else {
                    int left = 0, right = flowerCount - 1;
                    while (left < right) {
                        int mid = (left + right + 1) >> 1;
                        if (ends[mid] < arrival) {
                            left = mid;
                        } else {
                            right = mid - 1;
                        }
                    }
                    close = left + 1;
                }
                result[index] = open - close;
            }
            return result;
        }
    }

}
