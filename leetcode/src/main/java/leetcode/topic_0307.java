package leetcode;

@SuppressWarnings("unused")
public class topic_0307 {
    class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int index = left; index <= right && index < nums.length; index++) {
                sum += nums[index];
            }
            return sum;
        }
    }
}
