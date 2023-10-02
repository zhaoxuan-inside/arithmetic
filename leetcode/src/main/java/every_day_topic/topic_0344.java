package every_day_topic;

@SuppressWarnings("unused")
public class topic_0344 {
    public void reverseString(char[] s) {
        int len = s.length;

        char tmp;
        int end;
        for (int index = 0; index < len / 2; index++) {
            end = len - index - 1;
            tmp = s[index];
            s[index] = s[end];
            s[end] = tmp;
        }
    }

}
