package leetcode;

@SuppressWarnings("unused")
public class topic_3170 {
    public static String clearStars(String s) {
        char[] chars = s.toCharArray();
        int fast = 0, slow = 0;
        while (fast < chars.length) {
            if (chars[fast] == '*') {
                if (slow > 0) {
                    slow--;
                }
                fast++;
            }
            if (fast == chars.length) {
                break;
            }

            if (fast != slow) {
                chars[slow] = chars[fast];
            }
            slow++;
            fast++;
        }
        return new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(clearStars("a*bc*"));
    }

}
