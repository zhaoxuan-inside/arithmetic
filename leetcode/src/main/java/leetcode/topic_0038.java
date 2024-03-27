package leetcode;

@SuppressWarnings("unused")
public class topic_0038 {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String last = countAndSay(n - 1);
        return say(last);
    }

    private static String say(String str) {
        int last = -1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < str.length(); idx++) {
            int curr = str.charAt(idx) - '0';
            if (last == -1 || curr == last) {
                count++;
                last = curr;
                continue;
            }
            sb.append(count).append(last);
            last = curr;
            count = 1;
        }
        sb.append(count).append(last);
        return sb.toString();
    }

}
