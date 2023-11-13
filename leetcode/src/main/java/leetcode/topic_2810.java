package leetcode;

@SuppressWarnings("unused")
public class topic_2810 {
    public String finalString(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == 'i') {
                result.reverse();
                continue;
            }

            result.append(ch);

        }

        return result.toString();

    }
}
