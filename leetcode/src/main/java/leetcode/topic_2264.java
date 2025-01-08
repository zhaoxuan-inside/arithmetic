package leetcode;

@SuppressWarnings("unused")
public class topic_2264 {

    private final static String[] STR = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};

    public String largestGoodInteger(String num) {

        if (num.length() < 3) {
            return "";
        }

        for (int idx = STR.length - 1; idx >= 0; idx--) {
            if (num.contains(STR[idx])) {
                return STR[idx];
            }
        }

        return "";

    }

}
