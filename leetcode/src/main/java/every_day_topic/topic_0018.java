package every_day_topic;

import java.util.*;

/**
 *
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 */
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

                while (pre < last){
                    int preNum = nums[pre];
                    int lastNum = nums[last];

                    long sum = (long) firstNum + secondNum + preNum + lastNum;

                    if (sum - target == 0){
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

                    if (sum - target > 0){
                        last--;
                    } else {
                        pre++;
                    }

                }
            }
        }

        return new ArrayList<>(result);
    }

}
