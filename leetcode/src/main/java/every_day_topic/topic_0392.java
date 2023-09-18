package every_day_topic;

@SuppressWarnings("unused")
public class topic_0392 {
    public boolean isSubsequence(String s, String t) {

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        int sIndex = 0, tIndex = 0;
        while (sIndex < sCharArray.length && tIndex < tCharArray.length) {

            if (sCharArray.length - sIndex + tIndex > tCharArray.length) {
                return false;
            }

            if (sCharArray[sIndex] == tCharArray[tIndex]) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }

        return sIndex == s.length();
    }
}
