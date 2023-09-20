package every_day_topic;

import java.util.List;

@SuppressWarnings("unused")
public class topic_2828 {
    public boolean isAcronym(List<String> words, String s) {

        int length = s.length();
        if (words.size() != length) {
            return false;
        }
        for (int index = 0; index < words.size(); index++) {
            if (words.get(index).charAt(0) != s.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
