package leetcode;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0722 {

    private final static String BLOCK_START = "/*";
    private final static String BLOCK_END = "/*/";
    private final static String ROW_COMMENT = "//";

    private final static String CONTINUE = "/*/";

    public static List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();

        Stack<String> stack = new Stack<>();


        for (String row : source) {
            if (row.contains(CONTINUE)) {
                continue;
            }

            if (row.contains(ROW_COMMENT)) {
                String[] split = row.split(ROW_COMMENT);
                if (split.length > 1) {
                    result.add(split[0]);
                }
                continue;
            }

            if (row.contains(BLOCK_START)) {
                String[] splitStart = row.split(BLOCK_START);
                if (splitStart.length > 1) {
                    result.add(splitStart[0]);
                }
                if (!row.contains(BLOCK_END)) {
                    stack.push(BLOCK_START);
                } else {
                    String[] splitEnd = row.split(BLOCK_END);
                    if (splitEnd.length > 1) {
                        result.add(splitEnd[splitEnd.length - 1]);
                    }
                }
                continue;
            }

            if (row.contains(BLOCK_END)) {
                stack.pop();
                String[] splitEnd = row.split(BLOCK_END);
                if (splitEnd.length > 1) {
                    result.add(splitEnd[splitEnd.length - 1]);
                }
                continue;
            }

            if (!stack.isEmpty()) {
                continue;
            }

            result.add(row);

        }

        return result;

    }

}
