package leetcode;

@SuppressWarnings("unused")
public class topic_0907 {
    private static final long MODE = 1000000007;

    public static int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int len = arr.length;
        int[] mem = new int[len];

        for (int start = 0; start < len; start++) {
            mem[start] = arr[start];
            ans += mem[start];
            for (int end = start + 1; end < len; end++) {
                mem[end] = Math.min(arr[end], mem[end - 1]);
                ans += mem[end];
                ans %= MODE;
            }
        }
        return (int) ans;
    }

}
