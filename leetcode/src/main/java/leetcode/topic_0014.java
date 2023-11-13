package leetcode;

public class topic_0014 {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder result = new StringBuilder();
        int min = strs[0].length();

        for (String str : strs) {
            if (min > str.length()) {
                min = str.length();
            }
        }

        for (int i = 0; i < min; i++) {
            char ch = strs[0].charAt(i);

            for (String str : strs){
                if (ch != str.charAt(i)){
                    return result.toString();
                }
            }

            result.append(ch);
        }

        return result.toString();
    }
}
