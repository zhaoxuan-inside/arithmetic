package leetcode;

@SuppressWarnings("unused")
public class topic_2475 {

    public int unequalTriplets(int[] nums) {

        int sum = 0;

        for (int start = 0; start < nums.length - 2; start++) {
            for (int mid = start + 1; mid < nums.length - 1; mid++) {
                for (int end = mid + 1; end < nums.length; end++) {
                    if (nums[start] != nums[mid] && nums[start] != nums[end] && nums[mid] != nums[end]) {
                        sum++;
                    }
                }
            }
        }

        return sum;

    }

}
