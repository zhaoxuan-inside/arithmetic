package leetcode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class topic_0202 {
    public boolean isHappy(int n) {
        int ans = n;
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (ans == 1) {
                return true;
            }

            int curr = 0;
            while (ans / 10 > 0) {
                int num = ans % 10;
                curr += num * num;
                ans /= 10;
            }
            ans = curr;
            if (set.contains(ans)) {
                return false;
            } else {
                set.add(ans);
            }
        }
    }
}
