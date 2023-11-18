package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_2342 {
    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int bitSum = calculateBitSum(num);
            List<Integer> integers = map.get(bitSum);
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(num);
            map.put(bitSum, integers);
        }

        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            List<Integer> values = map.get(key);
            if (values.size() > 1) {
                values.sort((num1, num2) -> num2 - num1);
                int currSum = values.get(0) + values.get(1);
                max = Math.max(max, currSum);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;

    }

    private static int calculateBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num /= 10;
        }
        return sum;
    }

    public int batter(int[] nums) {
        int[] maxBitSum = new int[100];
        int ans = -1;
        for (int num : nums) {
            int bitSum = 0;
            int currNum = num;
            while (currNum != 0) {
                bitSum += currNum % 10;
                currNum /= 10;
            }
            if (maxBitSum[bitSum] != 0) {
                ans = Math.max(ans, num + maxBitSum[bitSum]);
            }
            maxBitSum[bitSum] = Math.max(maxBitSum[bitSum], num);
        }
        return ans;
    }

}
