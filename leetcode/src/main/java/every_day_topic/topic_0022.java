package every_day_topic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_0022 {

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return RESULT;
        }
        getParenthesis("", n, n);
        return RESULT;
    }

    private static void getParenthesis(String str, int leftRemain, int rightRemain) {
        // 退出递归
        if (leftRemain == 0 && rightRemain == 0) {
            RESULT.add(str);
            return;
        }

        // 左右括号匹配，则下一个括号为 （
        if (leftRemain == rightRemain) {
            getParenthesis(str + "(", leftRemain - 1, rightRemain);
        } else {
            // 左括号多余右括号
            if (leftRemain < rightRemain) {
                if (leftRemain > 0) {
                    getParenthesis(str + "(", leftRemain - 1, rightRemain);
                }
                getParenthesis(str + ")", leftRemain, rightRemain - 1);
            }
        }
    }

    private static final List<String> RESULT = new ArrayList<>();

    public static List<String> generateParenthesis2(int n) {
        if (n <= 0){
            return RESULT;
        }
        generate("", n, n);
        return RESULT;
    }

    private static void generate(String result, int leftRemain, int rightRemain) {

        if (leftRemain == 0 && rightRemain == 0) {
            RESULT.add(result);
            return;
        }

        if (leftRemain == rightRemain) {
            generate(result + "(", leftRemain - 1, rightRemain);
        } else {
            if (leftRemain > 0) {

                generate(result + "(", leftRemain - 1, rightRemain);

            }

            generate(result + ")", leftRemain, rightRemain - 1);

        }
    }

}
