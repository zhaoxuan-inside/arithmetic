package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] mem = new boolean[s.length() + 1];
        mem[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (mem[start] && wordDictSet.contains(s.substring(start, end))) {
                    mem[end] = true;
                    break;
                }
            }
        }
        return mem[s.length()];
    }
}
