package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0030 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int len = words.length * wordLen;
        if (s.length() < len) {
            return ans;
        }

        List<String> list = Arrays.asList(words);
        for (int idx = 0; idx < s.length() - len; idx++) {
            String substring = s.substring(idx, idx + wordLen);
            if (!list.contains(substring)) {
                continue;
            }
            List<String> copy = new ArrayList<>(list);
            copy.remove(substring);
            for (int count = 1; count < words.length; count++) {
                int startIdx = idx + count * wordLen;
                String currSubString = s.substring(startIdx, startIdx + wordLen);
                if (!copy.contains(currSubString)) {
                    break;
                }
                copy.remove(currSubString);
            }
            if (copy.size() == 0) {
                ans.add(idx);
            }
        }

        return ans;
    }

}
