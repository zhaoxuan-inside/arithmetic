package leetcode;

@SuppressWarnings("unused")
public class topic_0004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;

        int[] nums = new int[totalLength];

        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while (index1 < nums1.length && index2 < nums2.length) {

            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 < num2) {
                index1++;
                nums[index] = num1;
            } else {
                index2++;
                nums[index] = num2;
            }

            index++;

        }

        if (index1 < nums1.length) {
            while (index1 < nums1.length) {
                nums[index] = nums1[index1];
                index1++;
                index++;
            }
        }

        if (index2 < nums2.length) {
            while (index2 < nums2.length) {
                nums[index] = nums2[index2];
                index2++;
                index++;
            }
        }

        boolean isOdd = totalLength % 2 == 1;
        int half = totalLength / 2;

        if (isOdd) {
            return nums[half];
        } else {
            return (nums[half] + nums[half - 1]) / 2.0;
        }

    }

}
