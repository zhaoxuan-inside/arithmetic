package every_day_topic;

@SuppressWarnings("unused")
public class topic_0028 {
    public static int strStr(String haystack, String needle) {
        int hayIndex;
        int needleIndex = 0;

        for (hayIndex = 0; hayIndex < haystack.length() - needle.length() + 1; ) {

            while (needleIndex < needle.length() && haystack.charAt(hayIndex) == needle.charAt(needleIndex)) {
                hayIndex++;
                needleIndex++;
            }

            if (needleIndex == needle.length()) {
                return hayIndex - needleIndex;
            } else {
                hayIndex = hayIndex - needleIndex + 1;
                needleIndex = 0;
            }

        }

        return -1;

    }

}
