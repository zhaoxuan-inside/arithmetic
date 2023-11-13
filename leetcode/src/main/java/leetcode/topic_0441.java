package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0441 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int hour = 0; hour < 12; ++hour) {
            for (int minute = 0; minute < 60; ++minute) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    ans.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
                }
            }
        }
        return ans;
    }
}
