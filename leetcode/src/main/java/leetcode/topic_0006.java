package leetcode;

@SuppressWarnings("unused")
public class topic_0006 {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows == s.length() || s.length() == 0) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int idx = 0; idx < numRows; idx++) {
            sbs[idx] = new StringBuilder();
        }

        int single = -1;
        int sbIdx = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            sbs[sbIdx].append(ch);
            if (sbIdx == numRows - 1 || sbIdx == 0) {
                single *= -1;
            }
            sbIdx += single;
        }

        for (int idx = 1; idx < numRows; idx++) {
            sbs[0].append(sbs[idx]);
        }

        return sbs[0].toString();
    }

    public String better(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        char[] str = s.toCharArray();
        int len = str.length;
        char[] ans = new char[len];
        int p = 2 * numRows - 2;
        int index = 0;
        for (int row = 0; row < numRows; row++) {
            for (int begin = 0; begin + row < len; begin += p) {
                ans[index++] = str[begin + row];
                if (row != 0 && row != numRows - 1 && begin + p - row < len) {
                    ans[index++] = str[begin + p - row];
                }
            }
        }
        return new String(ans);
    }

}
