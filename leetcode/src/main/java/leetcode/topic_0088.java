package leetcode;

@SuppressWarnings("unused")
public class topic_0088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            if (n >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
            }
            return;
        }

        int[] copyNums1 = new int[m];

        System.arraycopy(nums1, 0, copyNums1, 0, m);

        int index1 = 0;
        int index2 = 0;
        int index;
        for (index = 0; index < m + n; index++) {

            if (index1 >= m || index2 >= n) {
                break;
            }

            if (copyNums1[index1] < nums2[index2]) {
                nums1[index] = copyNums1[index1];
                index1++;
            } else {
                nums1[index] = nums2[index2];
                index2++;
            }
        }

        if (index1 < m) {
            for (int indexRemain = index1; indexRemain < m; indexRemain++) {
                nums1[index] = copyNums1[indexRemain];
                index++;
            }
            return;
        }

        for (int indexRemain = index2; indexRemain < n; indexRemain++) {
            nums1[index] = nums2[indexRemain];
            index++;
        }
    }

}
