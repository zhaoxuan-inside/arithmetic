package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0833 {
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        char[] charArray = s.toCharArray();

        int length = indices.length;

        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<String> strs = new ArrayList<>();
            strs.add(sources[i]);
            strs.add(targets[i]);

            map.put(indices[i], strs);
        }

        Arrays.sort(indices);
        StringBuilder result = new StringBuilder();
        if (indices[0] > 0) {
            result.append(s, 0, indices[0]);
        }

        for (int count = 0; count < length; count++) {

            int start = indices[count];
            String source = map.get(start).get(0);
            String target = map.get(start).get(1);

            if (!checkExist(start, charArray, source)) {
                String substring = s.substring(start, count < length - 1 ? indices[count + 1] : s.length());
                result.append(substring);
                continue;
            }

            result.append(target);
            int gap = (count < length - 1 ? indices[count + 1] : s.length()) - start;
            int remain = source.length() >= gap ?
                    0 :
                    gap - source.length();
            if (remain > 0) {
                start += source.length();
                result.append(s, start, start + remain);
            }
        }

        return result.toString();

    }

    private static boolean checkExist(int start, char[] chars, String source) {
        for (int index = start; index < start + source.length(); index++) {
            if (chars[index] != source.charAt(index - start)) {
                return false;
            }
        }
        return true;
    }

}
