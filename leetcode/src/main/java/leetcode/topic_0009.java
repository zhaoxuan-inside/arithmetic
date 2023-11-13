package leetcode;

@SuppressWarnings("unused")
public class topic_0009 {
    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}
