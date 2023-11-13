package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class compete_100077 {
    private static int[] wordLens;

    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        wordLens = new int[n];
        for (int index = 0; index < n; index++) {
            wordLens[index] = words[index].length();
        }

        List<Integer> sub = findSub(groups, 0);
        List<String> ans = new ArrayList<>();
        for (Integer index : sub) {
            ans.add(words[index]);
        }
        return ans;

    }

    private static List<Integer> findSub(int[] group, int startIndex) {

        List<Integer> indexList = new ArrayList<>();
        List<Integer> otherIndexList = new ArrayList<>();

        indexList.add(0);
        int last = group[0];
        for (int index = startIndex + 1; index < group.length; index++) {
            if (last != group[index] &&
                    group[index] < group.length &&
                    wordLens[last] == wordLens[group[index]]) {
                indexList.add(index);
                last = group[index];
            } else {
                otherIndexList = findSub(group, index);
            }
        }

        return indexList.size() > otherIndexList.size() ? indexList : otherIndexList;

    }

}
