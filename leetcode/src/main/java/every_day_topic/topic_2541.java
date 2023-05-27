package every_day_topic;

import java.util.*;

public class topic_2541 {
    public String oddString(String[] words) {

        String first = Arrays.toString(getDifference(words[0]));
        String second = Arrays.toString(getDifference(words[1]));

        for (int index = 2; index < words.length; index++) {
            String curr = Arrays.toString(getDifference(words[index]));

            if (first.equals(second)) {
                if (!curr.equals(first)) {
                    return words[index];
                }
            } else {
                if (curr.equals(first))  {
                    return words[1];
                } else {
                    return words[0];
                }
            }
        }

        return "";
    }

    private int[] getDifference(String word) {

        char[] charArray = word.toCharArray();
        int[] diff = new int[word.length() - 1];

        for (int index = 0; index < charArray.length - 1; index++) {
            diff[index] = charArray[index + 1] - charArray[index];
        }

        return diff;

    }


    class Solution {
        public String oddString(String[] words) {
            int[] diff0 = get(words[0]);
            int[] diff1 = get(words[1]);

            if (Arrays.equals(diff0, diff1)) {
                for (int i = 2; i < words.length; i++) {
                    if (!Arrays.equals(diff0, get(words[i]))) {
                        return words[i];
                    }
                }
            }
            return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
        }

        public int[] get(String word) {
            int[] diff = new int[word.length() - 1];
            for (int i = 0; i < word.length() - 1; i++) {
                diff[i] = word.charAt(i + 1) - word.charAt(i);
            }
            return diff;
        }
    }

}


