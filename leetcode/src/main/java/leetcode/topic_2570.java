package leetcode;

import java.util.Arrays;

/**
 * 给你两个 二维 整数数组 nums1 和 nums2.
 * <p>
 * nums1[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * nums2[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * 每个数组都包含 互不相同 的 id ，并按 id 以 递增 顺序排列。
 * <p>
 * 请你将两个数组合并为一个按 id 以递增顺序排列的数组，并符合下述条件：
 * <p>
 * 只有在两个数组中至少出现过一次的 id 才能包含在结果数组内。
 * 每个 id 在结果数组中 只能出现一次 ，并且其对应的值等于两个数组中该 id 所对应的值求和。如果某个数组中不存在该 id ，则认为其对应的值等于 0 。
 * 返回结果数组。返回的数组需要按 id 以递增顺序排列。
 */

@SuppressWarnings("unused")
public class topic_2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;

        int num1Index = 0;
        int num2Index = 0;

        int[][] ans = new int[num1Len + num2Len][2];
        int index = 0;

        while (num1Index < num1Len || num2Index < num2Len) {
            int num1Id = Integer.MAX_VALUE;
            int num2Id = Integer.MAX_VALUE;

            if (num1Index < num1Len) {
                num1Id = nums1[num1Index][0];
            }

            if (num2Index < num2Len) {
                num2Id = nums2[num2Index][0];
            }

            if (num1Id < num2Id) {
                ans[index] = nums1[num1Index++];
            } else if (num1Id == num2Id) {
                ans[index] = new int[]{num1Id, nums1[num1Index++][1] + nums2[num2Index++][1]};
            } else {
                ans[index] = nums2[num2Index++];
            }

            index++;

        }

        return index == num1Len + num2Len ? ans : Arrays.copyOfRange(ans, 0, index);

    }
}
