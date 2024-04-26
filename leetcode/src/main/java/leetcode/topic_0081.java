package leetcode;

@SuppressWarnings("unused")
public class topic_0081 {
    public static boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static boolean search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;

        if (nums[start] == target || nums[mid] == target || nums[end] == target) {
            return true;
        }

        if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
            return search(nums, target, start, mid - 1) || search(nums, target, mid + 1, end);
        }

        if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
            if (nums[mid] > target) {
                return search(nums, target, start, mid - 1);
            } else {
                return search(nums, target, mid + 1, end);
            }
        }

        return search(nums, target, start, mid - 1) || search(nums, target, mid + 1, end);
    }

    public static void main(String[] args) {
//        for (int i = -5; i < 15; i++) {
//            System.out.println("find " + i + " result : " + search(new int[]
//                            {1, 1, 1, 2, 1, 1},
//                    i));
//        }
        System.out.println("find " + 3 + " result : " + search(new int[]
                        {2,2,2,3,2,2,2},
                3));
    }
}
