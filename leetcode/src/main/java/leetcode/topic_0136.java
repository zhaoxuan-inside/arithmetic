package leetcode;

@SuppressWarnings("unused")
public class topic_0136 {
    public static int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
            singleNum = singleNum ^ num;
        }
        return singleNum;
    }

}
