package leetcode;

@SuppressWarnings("unused")
public class topic_0043 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder num2Sb = new StringBuilder(num2).reverse();
        StringBuilder zero = new StringBuilder();
        num1 = new StringBuilder(num1).reverse().toString();
        for (int idx = 0; idx < num1.length(); idx++) {
            char ch = num1.charAt(idx);
            StringBuilder curr = subMultiply(num2Sb, ch).reverse();
            curr.append(zero);
            if (ans.length() > curr.length()) {
                ans = add(ans.reverse(), curr.reverse()).reverse();
            } else {
                ans = add(curr.reverse(), ans.reverse()).reverse();
            }
            zero.append('0');
        }

        return ans.toString();
    }

    private static StringBuilder subMultiply(StringBuilder big, char little) {
        StringBuilder sb = new StringBuilder();
        if (little == '0') {
            return sb.append('0');
        }
        if (little == '1') {
            return big;
        }
        char bit = '0';
        for (int idx = 0; idx < big.length(); idx++) {
            char bigChar = big.charAt(idx);
            int multi = (bigChar - '0') * (little - '0') + bit - '0';
            sb.append((char) (multi % 10 + '0'));
            bit = (char) (multi / 10 + '0');
        }
        if (bit - '0' > 0) {
            sb.append(bit);
        }
        return sb;
    }

    private static StringBuilder add(StringBuilder big, StringBuilder little) {
        StringBuilder sb = new StringBuilder();
        char bit = '0';
        for (int idx = 0; idx < big.length(); idx++) {
            char bigChar = big.charAt(idx);
            char littleChar = '0';
            if (little.length() > idx) {
                littleChar = little.charAt(idx);
            }
            int sum = bigChar - '0' + littleChar - '0' + bit - '0';
            sb.append((char) (sum % 10 + '0'));
            bit = (char) (sum / 10 + '0');

        }
        if (bit - '0' > 0) {
            sb.append(bit);
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(multiply("913", "25"));
    }

}
