package every_day_topic;

@SuppressWarnings("unused")
public class topic_0215 {

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, k - 1, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void quickSort(int[] list, int index, int left, int right) {
        if (left < right) {
            int base = division(list, left, right);
            if (base == index) {
                return;
            }
            if (base > index) {
                quickSort(list, index, left, base - 1);
            } else {
                quickSort(list, index, base + 1, right);
            }
        }
    }

    public static int division(int[] list, int left, int right) {
        int base = list[left];

        while (left < right) {
            while (left < right && list[right] <= base) {
                right--;
            }
            list[left] = list[right];

            while (left < right && list[left] > base) {
                left++;
            }
            list[right] = list[left];
        }
        list[left] = base;
        return left;
    }

}
