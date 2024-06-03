package leetcode;

public class topic_0168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int ch = columnNumber % 26;
            columnNumber = columnNumber / 26;
            sb.insert(0, (char) ('A' + ch));
        }
        return sb.toString();
    }
}
