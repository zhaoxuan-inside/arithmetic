package leetcode;

import java.util.Stack;

public class topic_1003 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (ch != 'c') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop1 = stack.pop();

                if (stack.isEmpty()) {
                    return false;
                }
                Character pop2 = stack.pop();

                if (!(String.valueOf(pop2) + pop1 + ch).equals("abc")) {
                    return false;
                }
            }

        }
       return stack.isEmpty();
    }
}
