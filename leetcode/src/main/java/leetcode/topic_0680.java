package leetcode;

@SuppressWarnings("unused")
public class topic_0680 {
    public static boolean validPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return subValidPalindrome(s, startIndex, endIndex - 1) ||
                        subValidPalindrome(s, startIndex + 1, endIndex);
            }
        }
        return true;
    }

    private static boolean subValidPalindrome(String s, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
