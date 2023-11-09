package every_day_topic;


import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_0824 {
    public static String toGoatLatin(String sentence) {

        Set<Character> chars = new HashSet<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');
        chars.add('A');
        chars.add('E');
        chars.add('I');
        chars.add('O');
        chars.add('U');

        String[] words = sentence.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');

        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            char ch = word.charAt(0);
            if (!chars.contains(ch)) {
                word = word.substring(1) + ch;
            }
            word += "ma";
            word += stringBuilder.toString();
            stringBuilder.append('a');
            ans.append(word);
            ans.append(" ");
        }

        return ans.substring(0, ans.length() - 1);

    }

}
