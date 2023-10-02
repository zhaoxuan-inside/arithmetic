package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0345 {
    public String reverseVowels(String s) {

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int start = 0;
        int end = s.length() - 1;
        char tmp;
        char[] charArray = s.toCharArray();
        while (start < end) {
            boolean startContain = vowels.contains(charArray[start]);
            boolean endContain = vowels.contains(charArray[end]);
            if (!startContain) {
                start++;
                continue;
            }

            if (!endContain) {
                end--;
                continue;
            }

            tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
            start++;
            end--;
        }

        return String.valueOf(charArray);

    }
}
