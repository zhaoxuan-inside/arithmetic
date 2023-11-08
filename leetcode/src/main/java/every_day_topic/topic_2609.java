package every_day_topic;

@SuppressWarnings("unused")
public class topic_2609 {
    public static int findTheLongestBalancedSubstring(String s) {
        int maxLen = 0;
        int length = s.length();
        int[] mem = new int[length];

        for (int index = 0; index < length; index++) {
            char currCh = s.charAt(index);
            if (currCh == '1') {
                if (index - 1 >= 0) {
                    if (s.charAt(index - 1) == '0') {
                        mem[index] = 2;
                    } else {
                        int subLen = mem[index - 1];
                        if (index - subLen > 0 && s.charAt(index - subLen - 1) == '0') {
                            mem[index] = mem[index - 1] + 2;
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, mem[index]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestBalancedSubstring("010101010101"));
    }
}
