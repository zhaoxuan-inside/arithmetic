package every_day_topic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class compete_100078 {
    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {

        List<Integer> zeroGroupList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> oneGroupList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        zeroGroupList.add(0);
        zeroList.add(0);
        oneGroupList.add(1);
        oneList.add(1);

        for (int index = 0; index < n; index++) {
            if (groups[index] != zeroGroupList.get(zeroGroupList.size() - 1)) {
                zeroGroupList.add(groups[index]);
                zeroList.add(index);
            }
            if (groups[index] != oneGroupList.get(oneGroupList.size() - 1)) {
                oneGroupList.add(groups[index]);
                oneList.add(index);
            }
        }

        zeroList = zeroList.size() > oneList.size() ? zeroList : oneList;

        List<String> ans = new ArrayList<>();
        for (int index = 1; index < zeroList.size(); index++) {
            ans.add(words[zeroList.get(index)]);
        }

        return ans;
    }

}
