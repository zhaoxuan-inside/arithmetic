package every_day_topic;

import java.util.*;

/**
 * 给你一个下标从 0 开始的字符串数组 words 。
 * <p>
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 * <p>
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= word.length - 1 。
 */
@SuppressWarnings("unused")
public class topic_2506 {
    public static int similarPairs(String[] words) {

        Map<Set<Character>, List<Integer>> map = new HashMap<>();

        for (int index = 0; index < words.length; index++) {

            Set<Character> set = new HashSet<>();
            for (char ch : words[index].toCharArray()) {
                set.add(ch);
            }
            List<Integer> wordIndex = map.get(set);
            if (wordIndex == null) {
                wordIndex = new ArrayList<>();
            }
            wordIndex.add(index);
            map.put(set, wordIndex);
        }

        int result = 0;
        for (List<Integer> value : map.values()) {
            result += value.size() * (value.size() - 1) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"});
    }
}
