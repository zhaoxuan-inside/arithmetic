package leetcode;

@SuppressWarnings("unused")
public class compete_100131 {
    public static int findMinimumOperations(String s1, String s2, String s3) {
        int ans = 0;
        int minLen = 0;

        minLen = Math.min(s1.length(), s2.length());
        minLen = Math.min(minLen, s3.length());
        ans += s1.length() - minLen;
        ans += s2.length() - minLen;
        ans += s3.length() - minLen;
        s1 = s1.substring(0, minLen);
        s2 = s2.substring(0, minLen);
        s3 = s3.substring(0, minLen);

        while (minLen > 0) {
            if (s1.equals(s2) && s2.equals(s3)) {
                return ans;
            }
            ans += 3;
            s1 = s1.substring(0, minLen - 1);
            s2 = s2.substring(0, minLen - 1);
            s3 = s3.substring(0, minLen - 1);
            minLen--;
        }
        return -1;
    }

}
