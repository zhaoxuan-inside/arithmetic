package every_day_topic;

@SuppressWarnings("unused")
public class topic_0066 {
    public static int[] plusOne(int[] digits) {
        int bit = 0;
        int last = digits[digits.length - 1] + 1;
        bit = last / 10;
        digits[digits.length - 1] = last % 10;
        for (int index = digits.length - 2; index >= 0; index--) {
            int curr = digits[index] + bit;
            bit = curr / 10;
            digits[index] = curr % 10;
        }
        if (bit == 1) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = bit;
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            return tmp;
        }

        return digits;
    }

    public static void main(String[] args) {
//        plusOne(new int[]{1, 2, 3});
        plusOne(new int[]{8, 9, 9, 9});
    }

}
