package leetcode;

public class topic_0171 {
    public static int titleToNumber(String columnTitle) {
        if (columnTitle.isEmpty()) return 0;
        columnTitle = columnTitle.toUpperCase();
        if (columnTitle.length() == 1) return columnTitle.charAt(0) - 'A' + 1;
        int ans = 0;
        for (int idx = 0; idx < columnTitle.length() - 1; idx++) {
            ans *= 26;
            ans += (columnTitle.charAt(idx) - 'A' + 1) * 26;
        }

        return ans + columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1;
    }

}
