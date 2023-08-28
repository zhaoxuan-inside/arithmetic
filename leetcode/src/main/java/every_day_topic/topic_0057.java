package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0057 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (null == intervals || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int[][] result = new int[intervals.length + 1][intervals[0].length];

        int index = 0;
        boolean ifSuperposition = false;
        for (int[] interval : intervals) {
            if (ifSuperposition(interval, newInterval)) {
                if (ifSuperposition) {
                    combination(result[index - 1], interval);
                } else {
                    combination(interval, newInterval);
                    result[index] = interval;
                    index++;
                }
                ifSuperposition = true;
            } else {
                if (interval[0] > newInterval[1]) {
                    if (index > 0 && result[index - 1][1] < newInterval[0]) {
                        result[index] = newInterval;
                        index++;
                    } else if (index == 0) {
                        result[index] = newInterval;
                        index++;
                    }
                }
                result[index] = interval;
                index++;
                ifSuperposition = false;
            }
        }

        if (result[index - 1][1] < newInterval[0]) {
            result[index] = newInterval;
            index++;
        }

        return Arrays.copyOfRange(result, 0, index);

    }

    private static boolean ifSuperposition(int[] arr1, int[] arr2) {
        return Math.max(arr1[0], arr2[0]) <= Math.min(arr1[1], arr2[1]);
    }

    private static void combination(int[] arr1, int[] arr2) {
        arr1[0] = Math.min(arr1[0], arr2[0]);
        arr1[1] = Math.max(arr1[1], arr2[1]);
    }

    public static void main(String[] args) {
//        insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
//        insert(new int[][]{}, new int[]{5,7});
        insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
    }

    public int[][] batterInsert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

}
