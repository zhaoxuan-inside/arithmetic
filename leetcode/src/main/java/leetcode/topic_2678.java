package leetcode;

@SuppressWarnings("unused")
public class topic_2678 {
    public static int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            if (detail.charAt(11) - '6' > 0 ||
                    (detail.charAt(11) == '6' && detail.charAt(12) - '0' > 0)) {
                ans++;
            }
        }
        return ans;
    }
}
