package leetcode;

@SuppressWarnings("unused")
public class topic_2652 {
    public int sumOfMultiples(int n) {
        int ans = 0;

        for (int index = 1; index <= n; index++) {
            if (index % 3 == 0 || index % 5 == 0 || index % 7 == 0) {
                ans += index;
            }
        }

        return ans;
    }
}
