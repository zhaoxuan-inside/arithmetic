package every_day_topic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class compete_100095 {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        List<String> nums = new ArrayList<>();
        int length = words.size();
        int numIndex = -1;
        for (int index = 0; index < length; index++) {
            if ("prev".equals(words.get(index))) {
                numIndex--;
                if (numIndex > -1 && numIndex < nums.size()) {
                    ans.add(Integer.parseInt(nums.get(numIndex)));
                } else {
                    ans.add(-1);
                }
            } else {
                nums.add(words.get(index));
                numIndex = index;
            }
        }
        return ans;
    }

}
