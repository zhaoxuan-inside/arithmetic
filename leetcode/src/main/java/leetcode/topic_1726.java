package leetcode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class topic_1726 {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int product = nums[start] * nums[end];
                Integer count = map.get(product);
                if (count == null) {
                    count = 0;
                }
                map.put(product, count + 1);
            }
        }

        int ans = 0;
        Map<Integer, Integer> product = new HashMap<>();
        for (Integer value : map.values()) {
            if (value <= 1) {
                continue;
            }
            Integer integer = product.get(value);
            if (integer == null) {
                integer = 1;
                int tmp = value;
                while (tmp > value - 2) {
                    integer *= tmp;
                    tmp--;
                }
                product.put(value, integer);
            }
            ans += integer * 4;
        }

        return ans;

    }

    public static void main(String[] args) {
        tupleSameProduct(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192});
    }
}
