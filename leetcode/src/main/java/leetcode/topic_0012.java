package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和X(10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和C(100) 的左边，来表示 40 和90。
 * C 可以放在 D (500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 */

public class topic_0012 {
    public String intToRoman(int num) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");

        String result = "";
        int dividend = 1000;
        
        while (dividend > 0){
            int n = num / dividend;

            String low = map.get(dividend);
            String upper = map.get(dividend * 10);
            String middle = map.get(dividend * 5);

            result += switchString(n, middle, low, upper);

            num = num % dividend;
            dividend = dividend / 10;

        }

        return result;
    }

    private String switchString(int num, String middle, String low, String upper) {
        if (num == 0){
            return "";
        }

        String result = middle;

        if (num == 9){
            return  low + upper;
        }

        if (num > 5){
            while (num > 5){
                result = result + low;
                num--;
            }

            return result;
        } else {
            if (num == 5){
                return middle;
            }

            if (num == 4) {
                return low + result;
            }

            result = "";
            while (num > 0){
                result += low;
                num--;
            }

            return result;
        }

    }
}