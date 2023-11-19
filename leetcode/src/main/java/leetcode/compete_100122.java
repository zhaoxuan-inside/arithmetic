package leetcode;

@SuppressWarnings("unused")
public class compete_100122 {
    public static long minimumSteps(String s) {
        boolean flag = false;
        int ans = 0;
        char[] charArray = s.toCharArray();

        int startIdx = 0;
        int endIdx = charArray.length - 1;

        while (startIdx < endIdx) {
            if (charArray[startIdx] == '0') {
                startIdx++;
                continue;
            }
            if (charArray[endIdx] == '1') {
                endIdx--;
                continue;
            }
            ans += endIdx - startIdx;
            endIdx--;
            startIdx++;
        }

        return ans;
    }

}
