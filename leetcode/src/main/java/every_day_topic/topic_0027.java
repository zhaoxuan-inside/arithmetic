package every_day_topic;

public class topic_0027 {
    public static int removeElement(int[] nums, int val) {

        int last = 0;
        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != val) {
                nums[last] = nums[index];
                last++;
            }

        }

        return last;

    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
    }
}
