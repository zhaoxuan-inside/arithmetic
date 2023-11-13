package leetcode;

@SuppressWarnings("unused")
public class topic_0342 {
    public boolean isPowerOfFour(int n) {
        double x = Math.log(n) / Math.log(4);
        return x > (int) x;
    }
}
