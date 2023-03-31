package leetcode;

import java.util.HashMap;
import java.util.Map;

public class interview_01_01 {
    public boolean isUnique(String astr) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);

            if (null != map.get(ch)){
                return false;
            }

            map.put(ch, 1);
        }

        return true;
    }
}
