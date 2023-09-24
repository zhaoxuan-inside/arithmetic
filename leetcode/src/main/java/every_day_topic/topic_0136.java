package every_day_topic;

@SuppressWarnings("unused")
public class topic_0136 {
    public static int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
            singleNum = singleNum ^ num;
        }
        return singleNum;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{2, 2, 1});
    }

}
