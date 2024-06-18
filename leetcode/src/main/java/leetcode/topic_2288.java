package leetcode;

@SuppressWarnings("unused")
public class topic_2288 {
    public static String discountPrices(String sentence, int discount) {
        String[] strings = sentence.split(" ");
        double dis = 1 - discount / 100.0;

        StringBuilder sb = new StringBuilder();

        boolean sign;
        for (String str : strings) {
            sign = true;
            if (str.length() > 1 && str.startsWith("$") && str.charAt(1) != '0') {
                for (int idx = 1; idx < str.length(); idx++) {
                    if (str.charAt(idx) < '0' || str.charAt(idx) > '9') {
                        sign = false;
                        break;
                    }
                }
                if (sign) {
                    str = "$" + String.format("%.2f", dis * Double.parseDouble(str.substring(1)));
                }
            }
            sb.append(str).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

}
