package leetcode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        Set<String> sets = new HashSet<>();
        for (String word : words) {
            if (sets.contains(word)) {
                sets.remove(word);
                ans++;
                continue;
            }
            sets.add(new StringBuilder(word).reverse().toString());
        }
        return ans;
    }
}
