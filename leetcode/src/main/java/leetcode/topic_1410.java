package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings("unused")
public class topic_1410 {

    private final static Map<String, Character> MAP = new HashMap<>();

    static {
        MAP.put("&quot;", '"');
        MAP.put("&apos;", '\'');
        MAP.put("&amp;", '&');
        MAP.put("&gt;", '>');
        MAP.put("&lt;", '<');
        MAP.put("&frasl;", '/');
    }


    public static String entityParser(String text) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int idx = 0; idx < text.length(); idx++) {
            char currChar = text.charAt(idx);
            if (currChar == ';') {
                stack.push(currChar);
                StringBuilder currSb = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    currSb.append(pop);

                    if (pop == '&') {
                        StringBuilder currSbAns = new StringBuilder();
                        Character character = MAP.get(currSb.reverse().toString());
                        for (Character stackChar : stack) {
                            currSbAns.append(stackChar);
                        }
                        currSbAns.append(character == null ? currSb : character);
                        ans.append(currSbAns);
                        currSb = new StringBuilder();
                        break;
                    }
                }
                ans.append(currSb.reverse());
                stack.clear();
            } else {
                stack.push(currChar);
            }
        }

        for (Character character : stack) {
            ans.append(character);
        }

        return ans.toString();
    }

}
