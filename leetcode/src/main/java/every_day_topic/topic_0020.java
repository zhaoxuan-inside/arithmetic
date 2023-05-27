package every_day_topic;

import java.util.Stack;

public class topic_0020 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char currChar;

        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);

            if (currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            } else {
                if (stack.empty()){
                    return false;
                }

                if (!match(stack.pop(), currChar)) {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean match(char ch1, char ch2){
        switch (ch1){
            case '(':
                return ch2 == ')';
            case '[':
                return ch2 == ']';
            case '{':
                return ch2 == '}';
        }

        return false;
    }
}
