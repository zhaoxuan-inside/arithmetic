package leetcode;

@SuppressWarnings("unused")
public class topic_0191 {
    public static int hammingWeight(int n) {
        if (n >= 0) {
            return Integer.bitCount(n);
        } else {
            return Integer.bitCount(-n) + 1;
        }
    }

}
