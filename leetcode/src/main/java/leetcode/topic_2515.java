package leetcode;

import java.util.Objects;

@SuppressWarnings("unused")
public class topic_2515 {
    public static int closetTarget(String[] words, String target, int startIndex) {
        int length = words.length;

        for (int gap = 1; gap <= words.length / 2 + 1; gap++) {
            int backward = (startIndex + gap) % length;
            int forward = (startIndex - gap + length) % length;

            if (Objects.equals(words[forward], target) || Objects.equals(words[backward], target)) {
                return gap;
            }
        }

        return -1;
    }

}
