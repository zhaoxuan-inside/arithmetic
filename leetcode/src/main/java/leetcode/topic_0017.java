package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0017 {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int len = digits.length();
        if (digits.length() == 0) {
            return ans;
        }

        PhoneMapEnum phoneMapEnum = PhoneMapEnum.getByNumber(digits.charAt(0) - '0');
        if (phoneMapEnum != null) {
            ans.addAll(Arrays.asList(phoneMapEnum.getChars()));
        }
        for (int idx = 1; idx < len; idx++) {
            char curr = digits.charAt(idx);
            PhoneMapEnum byNumber = PhoneMapEnum.getByNumber(curr - '0');
            if (byNumber != null) {
                List<String> currStrList = new ArrayList<>();
                for (String currStr : byNumber.getChars()) {
                    for (String str : ans) {
                        String currStrSave = str + currStr;
                        currStrList.add(currStrSave);
                    }
                }
                ans.clear();
                ans.addAll(currStrList);
            }
        }
        return ans;
    }

}

enum PhoneMapEnum {
    TWO(2, new String[]{"a", "b", "c"}),
    THREE(3, new String[]{"d", "e", "f"}),
    FOUR(4, new String[]{"g", "h", "i"}),
    FIVE(5, new String[]{"j", "k", "l"}),
    SIX(6, new String[]{"m", "n", "o"}),
    SEVEN(7, new String[]{"p", "q", "r", "s"}),
    EIGHT(8, new String[]{"t", "u", "v"}),
    NINE(9, new String[]{"w", "x", "y", "z"});


    private final int number;
    private final String[] chars;

    PhoneMapEnum(int number, String[] chars) {
        this.number = number;
        this.chars = chars;
    }

    public int getNumber() {
        return number;
    }

    public String[] getChars() {
        return chars;
    }

    public static PhoneMapEnum getByNumber(int number) {
        for (PhoneMapEnum value : PhoneMapEnum.values()) {
            if (value.getNumber() == number) {
                return value;
            }
        }
        return null;
    }
}
