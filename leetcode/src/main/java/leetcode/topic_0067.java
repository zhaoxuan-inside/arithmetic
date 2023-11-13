package leetcode;

@SuppressWarnings("unused")
public class topic_0067 {
    public static String addBinary(String a, String b) {
        int bit = 0;
        StringBuilder ans = new StringBuilder();

        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;
        int length = shorter.length() - 1;

        int index;
        for (index = 0; index < longer.length(); index++) {

            int curr = (longer.charAt(longer.length() - 1 - index) - '0') + bit;
            if (index < shorter.length()) {
                curr += shorter.charAt(shorter.length() - 1 - index) - '0';
            }
            bit = curr / 2;
            ans.append(curr % 2);
        }
        if (bit == 1) {
            ans.append(1);
        }

        return ans.reverse().toString();

    }

}
