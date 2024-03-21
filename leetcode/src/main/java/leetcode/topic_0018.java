package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
@SuppressWarnings("unused")
public class topic_0018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int first = 0; first < nums.length - 3; first++) {
            for (int second = first + 1; second < nums.length - 2; second++) {
                int firstNum = nums[first];
                int secondNum = nums[second];

                int pre = second + 1;
                int last = nums.length - 1;

                while (pre < last) {
                    int preNum = nums[pre];
                    int lastNum = nums[last];

                    long sum = (long) firstNum + secondNum + preNum + lastNum;

                    if (sum - target == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(firstNum);
                        tmp.add(secondNum);
                        tmp.add(preNum);
                        tmp.add(lastNum);

                        result.add(tmp);

                        pre++;
                        last--;
                        continue;
                    }

                    if (sum - target > 0) {
                        last--;
                    } else {
                        pre++;
                    }

                }
            }
        }

        return new ArrayList<>(result);
    }

    public static List<List<Integer>> better(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        for (int start = 0; start < len - 3; start++) {
            long min = 0L + nums[start] + nums[start + 1] + nums[start + 2] + nums[start + 3];
            if (min > target) {
                break;
            }
            long max = 0L + nums[start] + nums[len - 3] + nums[len - 2] + nums[len - 1];
            if (max < target) {
                continue;
            }

            for (int second = start + 1; second < len - 2; second++) {
                for (int thread = second + 1; thread < len - 1; thread++) {
                    for (int end = thread + 1; end < len; end++) {
                        int curr = nums[start] + nums[second] + nums[thread] + nums[end];
                        if (curr == target) {
                            List<Integer> ints = new ArrayList<>();
                            ints.add(nums[start]);
                            ints.add(nums[second]);
                            ints.add(nums[thread]);
                            ints.add(nums[end]);
                            ans.add(ints);
                        } else if (curr > target) {
                            break;
                        }

                    }
                }
            }

        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        better(new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000}, -1000000000);
    }

}
