package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class topic_2530 {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        for (int index = 0; index < k; index++) {
            int maxIndex = maxNumIndex(nums);
            ans += nums[maxIndex];
            nums[maxIndex] = ceil3(nums[maxIndex]);
            sort(nums, maxIndex);
        }
        return ans;
    }

    private int maxNumIndex(int[] nums) {
        int maxIndex = 0;
        for (int index = 1; index < nums.length; index++) {
            maxIndex = nums[index] > nums[maxIndex] ? index : maxIndex;
        }
        return maxIndex;
    }

    private int ceil3(int num) {
        return (num + 2) / 3;
    }

    private void sort(int[] nums, int modifyIdx) {

        int tmp = nums[modifyIdx];
        for (int index = modifyIdx; index > 0; index--) {
            if (nums[modifyIdx - 1] > nums[modifyIdx]) {
                nums[modifyIdx] = nums[modifyIdx - 1];
            } else {
                nums[modifyIdx] = tmp;
                return;
            }
        }

    }

    public long faster(int[] nums, int k) {
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            sortedQueue.offer(num);
        }
        Long ans = 0L;
        for (int i = 0; i < k; ++i) {
            Integer x = sortedQueue.poll();
            ans += x;
            sortedQueue.offer((x + 2) / 3);
        }
        return ans;
    }

    public long fastest(int[] nums, int k) {
        int length = nums.length;
        long ans = 0;
        while (length == 1) {
            ans += nums[0];
            nums[0] = (nums[0] + 2) / 3;
            k--;
            if (k == 0) {
                return ans;
            }
        }
        int m = k;
        int p = nums.length - 1;
        Arrays.sort(nums);

        while (k > 0) {
            ans += nums[p];
            nums[p] = (int) Math.ceil((double) nums[p] / 3);
            k--;
            if (k == m / 3) {
                Arrays.sort(nums);
                p = length - 1;
                continue;
            }
            if (p - 1 == length / 3) {
                Arrays.sort(nums);
                p = length - 1;
                continue;
            }
            p--;

        }
        return ans;
    }

}
