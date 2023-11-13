package leetcode;

@SuppressWarnings("unused")
public class topic_0459 {

    private static char[] charArray = new char[1];
    private static int length = 0;

    public static boolean repeatedSubstringPattern(String s) {
        charArray = s.toCharArray();
        length = charArray.length;

        int repeatCount = 2;

        while (repeatCount * 2 < length) {
            if (length % repeatCount == 0 && checkRepeat(repeatCount)) {
                return true;
            }
            repeatCount++;
        }
        return false;
    }

    private static boolean checkRepeat(int repeatCount) {
        for (int subEnd = repeatCount; subEnd < length; subEnd++) {
            if (charArray[subEnd] != charArray[subEnd - repeatCount]) {
                return false;
            }
        }
        return true;
    }

    static class Batter {
        public boolean repeatedSubstringPattern(String s) {
            int length = s.length();
            for (int subLength = 1; subLength * 2 <= length; ++subLength) {
                if (length % subLength == 0) {
                    boolean match = true;
                    for (int subEnd = subLength; subEnd < length; ++subEnd) {
                        if (s.charAt(subEnd) != s.charAt(subEnd - subLength)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
