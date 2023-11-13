package leetcode;

@SuppressWarnings("unused")
public class topic_0125 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startCh = s.charAt(start);
            if (!((startCh >= 'A' && startCh <= 'Z') ||
                    (startCh >= 'a' && startCh <= 'z') ||
                    (startCh >= '0' && startCh <= '9'))) {
                start++;
                continue;
            }
            char endCh = s.charAt(end);
            if (!((endCh >= 'A' && endCh <= 'Z') ||
                    (endCh >= 'a' && endCh <= 'z') ||
                    (endCh >= '0' && endCh <= '9'))) {
                end--;
                continue;
            }
            if (startCh >= 'A' && startCh <= 'Z') {
                startCh = (char) (startCh - 'A' + 'a');
            }

            if (endCh >= 'A' && endCh <= 'Z') {
                endCh = (char) (endCh - 'A' + 'a');
            }

            if (startCh != endCh) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
