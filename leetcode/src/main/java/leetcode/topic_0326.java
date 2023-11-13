package leetcode;

@SuppressWarnings("unused")
public class topic_0326 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        double x = Math.log(n) / Math.log(3);
        return Math.pow(3, (int) x) == n || Math.pow(3, (int) x + 1) == n;
    }
}
