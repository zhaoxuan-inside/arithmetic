package leetcode;

import java.util.Stack;

@SuppressWarnings("unused")
public class topic_0071 {
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : split) {
            switch (str) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop())
                    .insert(0, "/");
        }
        String ans = sb.toString();
        return "".equals(ans) ? "/" : ans;
    }

}
