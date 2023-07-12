package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0648 {

    private final Map<String, String> cache = new HashMap<>();

    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> list = new HashSet<>(dictionary);

        StringBuilder result = new StringBuilder();

        for (String word : sentence.split(" ")) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(list, word));
        }

        return result.toString();
    }

    private String findRoot(Set<String> roots, String word) {

        if (null != cache.get(word)) {
            return cache.get(word);
        }

        for (int last = 1; last < word.length(); last++) {
            String substring = word.substring(0, last);
            if (roots.contains(substring)) {
                cache.put(word, substring);
                return substring;
            }
        }

        cache.put(word, word);
        return word;

    }
}
