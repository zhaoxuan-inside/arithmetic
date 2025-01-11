package leetcode;

@SuppressWarnings("unused")
public class topic_3270 {

    public static int generateKey(int num1, int num2, int num3) {

        int ans = 0;

        for (int count = 1; count < 10000; count = count * 10) {
            int remain1 = num1 % 10;
            int remain2 = num2 % 10;
            int remain3 = num3 % 10;

            int min = Math.min(remain1, Math.min(remain2, remain3));
            ans += count * min;

            num1 = num1 / 10;
            num2 = num2 / 10;
            num3 = num3 / 10;
        }

        return ans;

    }

}
