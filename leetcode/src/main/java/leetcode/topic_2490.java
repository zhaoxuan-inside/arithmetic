package leetcode;

@SuppressWarnings("unused")
public class topic_2490 {
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");

        for (int index = 0; index < split.length - 1; index++) {
            if (split[index].charAt(split[index].length() - 1) != split[index + 1].charAt(0)) {
                return false;
            }
        }

        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
