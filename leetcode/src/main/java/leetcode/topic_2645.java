package leetcode;

import java.util.*;

/**
 * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
 * <p>
 * 只要 nums 不是 空数组，你就重复执行以下步骤：
 * <p>
 * 找到 nums 中的最小值，并删除它。
 * 找到 nums 中的最大值，并删除它。
 * 计算删除两数的平均值。
 * 两数 a 和 b 的 平均值 为 (a + b) / 2 。
 * <p>
 * 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
 * 返回上述过程能得到的 不同 平均值的数目。
 * <p>
 * 注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
 */
@SuppressWarnings("unused")
public class topic_2645 {
    public static int distinctAverages(int[] nums) {

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int add = nums[start] + nums[end];
            set.add(add);
        }
        return set.size();

    }

}
