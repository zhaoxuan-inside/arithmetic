package every_day_topic;

@SuppressWarnings("unused")
public class topic_0387 {
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        int[] mem = new int[26];
        for (char ch : charArray) {
            mem[ch - 'a']++;
        }
        for (int index = 0; index < charArray.length; index++) {
            if (mem[charArray[index] - 'a'] == 1) {
                return index;
            }
        }
        return -1;
    }
}
