package leetcode;

@SuppressWarnings("unused")
public class topic_0771 {
    public int numJewelsInStones(String jewels, String stones) {
        int jewelCount = 0;
        char[] charArray = jewels.toCharArray();
        for (char ch : stones.toCharArray()) {
            for (char jewelCh : charArray) {
                if (jewelCh == ch) {
                    jewelCount++;
                    break;
                }
            }
        }
        return jewelCount;
    }
}
