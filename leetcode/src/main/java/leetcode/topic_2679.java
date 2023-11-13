package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2679 {

    public int matrixSum(int[][] nums) {

        for (int[] num : nums) {
            Arrays.sort(num);
        }

        int sum = 0;

        for (int col = 0; col < nums[0].length; col++) {
            int max = nums[0][col];
            for (int row = 1; row < nums.length; row++) {
                max = Math.max(max, nums[row][col]);
            }
            sum += max;
        }

        return sum;

    }

    public int simpleMatrixSum(int[][] nums) {

        int[] mem = new int[nums[0].length];

        for (int[] num : nums) {
            Arrays.sort(num);
            for (int col = 0; col < nums[0].length; col++) {
                mem[col] = Math.max(num[col], mem[col]);
            }
        }

        return Arrays.stream(mem).sum();

    }

}
