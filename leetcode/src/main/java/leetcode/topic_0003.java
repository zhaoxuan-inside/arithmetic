package leetcode;

@SuppressWarnings("unused")
public class topic_0003 {

    public int lengthOfLongestSubstring(String s) {

        int length = s.length();

        if(length == 0) {
            return 0;
        }

        int lastArrayLength = 1;
        int max = 1;

        for (int currIndex = 1; currIndex < length; currIndex++) {

            int index = s.indexOf(s.charAt(currIndex), currIndex - lastArrayLength);

            if (index < currIndex) {
                lastArrayLength = currIndex - index;
            } else {
                lastArrayLength = lastArrayLength + 1;
            }

            max = Math.max(max, lastArrayLength);

        }

        return max;

    }

}