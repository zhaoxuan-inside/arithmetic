package pat.basic_level;

import java.util.Scanner;

public class Pat1001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (3 * num + 1) / 2;
            }
            count++;
        }
        System.out.println(count);
    }
}
