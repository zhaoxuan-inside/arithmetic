package leetcode;

@SuppressWarnings("unused")
public class topic_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Index;
        int word2Index;

        int word1CharIndex = 0;
        int word2CharIndex = 0;

        for (word1Index = 0, word2Index = 0; word1Index < word1.length && word2Index < word2.length; ) {
            String word1Str = word1[word1Index];
            String word2Str = word2[word2Index];

            while (word1CharIndex < word1Str.length() && word2CharIndex < word2Str.length()) {
                if (word1Str.charAt(word1CharIndex++) != word2Str.charAt(word2CharIndex++)) {
                    return false;
                }
            }

            if (word1CharIndex == word1Str.length()) {
                word1CharIndex = 0;
                word1Index++;
            }

            if (word2CharIndex == word2Str.length()) {
                word2CharIndex = 0;
                word2Index++;
            }

        }

        return word1Index == word1.length && word2Index == word2.length;

    }

    public boolean faster(String[] word1, String[] word2) {
        StringBuilder word1Sb = new StringBuilder();
        StringBuilder word2Sb = new StringBuilder();

        for (String str : word1) {
            word1Sb.append(str);
        }
        for (String str : word2) {
            word2Sb.append(str);
        }
        return word1Sb.toString().contentEquals(word2Sb);
    }
}
