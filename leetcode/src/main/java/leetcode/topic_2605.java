package leetcode;

public class topic_2605 {
    public int minNumber(int[] nums1, int[] nums2) {

        int min1 = nums1[0];
        int equal = 0;

        for (int j : nums1) {
            min1 = Math.min(min1, j);
            for (int i : nums2) {
                if (j == i) {
                    equal = Math.min(equal, i);
                }
            }
        }

        if (equal != 0) {
            return equal;
        }

        int min2 = nums2[0];

        for (int index = 1; index < nums2.length; index++) {
            min2 = Math.min(min2, nums2[index]);
        }

        return Math.min(min1, min2) * 10 + Math.max(min1, min2);

    }
}
