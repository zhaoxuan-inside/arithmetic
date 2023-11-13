package pat.basic_level;

import java.util.*;

public class Pat1002 {

    private static String[] num = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String input = sc.next();
        for (int index = 0; index < input.length(); index++) {
            sum += input.charAt(index) - '0';
        }

        StringBuilder sb = new StringBuilder();
        while (sum > 0) {
            sb.insert(0, num[sum % 10]);
            sb.insert(0, " ");
            sum /= 10;
        }

        System.out.println(sb.substring(1, sb.length()));
    }
}
