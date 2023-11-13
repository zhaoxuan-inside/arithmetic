package leetcode;

@SuppressWarnings("unused")
public class topic_0809 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (expand(s, word)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean expand(String str, String word) {
        int strIndex = 0, wordIndex = 0;
        while (strIndex < str.length() && wordIndex < word.length()) {
            if (str.charAt(strIndex) != word.charAt(wordIndex)) {
                return false;
            }
            char strCh = str.charAt(strIndex);
            int strCount = 0;
            while (strIndex < str.length() && str.charAt(strIndex) == strCh) {
                ++strCount;
                ++strIndex;
            }
            int wordCount = 0;
            while (wordIndex < word.length() && word.charAt(wordIndex) == strCh) {
                ++wordCount;
                ++wordIndex;
            }
            if (strCount < wordCount) {
                return false;
            }
            if (strCount != wordCount && strCount < 3) {
                return false;
            }
        }
        return strIndex == str.length() && wordIndex == word.length();
    }
}
