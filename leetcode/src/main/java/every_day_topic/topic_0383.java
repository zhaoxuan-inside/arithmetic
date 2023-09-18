package every_day_topic;

@SuppressWarnings("unused")
public class topic_0383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] mem = new int[52];

        for (char ch : magazine.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                mem[ch - 'A']++;
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                mem[ch - 'a']++;
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                if (mem[ch - 'A']-- == 0) {
                    return false;
                }
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                if (mem[ch - 'a']-- == 0) {
                    return false;
                }
            }
        }

        return true;

    }
}
