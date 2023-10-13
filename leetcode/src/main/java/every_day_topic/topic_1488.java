package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_1488 {

    private static final Set<Integer> FULL_LAKE = new HashSet<>();

    public static int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int[] ans = new int[length];

        for (int index = 0; index < length; index++) {
            if (rains[index] > 0) {
                if (FULL_LAKE.contains(rains[index])) {
                    return new int[0];
                }
                ans[index] = -1;
                FULL_LAKE.add(rains[index]);
                continue;
            }

            int nextLake = findNextLake(rains, index + 1);
            if (nextLake > 0) {
                if (FULL_LAKE.contains(nextLake)) {
                    ans[index] = nextLake;
                    FULL_LAKE.remove(nextLake);
                    continue;
                }
                if (!FULL_LAKE.isEmpty()) {
                    int emptyLake = FULL_LAKE.stream().findFirst().get();
                    FULL_LAKE.remove(emptyLake);
                    ans[index] = emptyLake;
                }
            }
        }
        return ans;
    }

    private static int findNextLake(int[] rains, int startIndex) {
        int ans = -1;
        for (int index = startIndex; index < rains.length; index++) {
            if (ans == -1) {
                ans = rains[index];
            }
            if (FULL_LAKE.contains(rains[index])) {
                return rains[index];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        avoidFlood(new int[]{1, 2, 0, 0, 2, 1});
    }

    public int[] faster(int[] rains) {
        int length = rains.length;
        int[] ans = new int[length];

        Arrays.fill(ans, 1);

        TreeSet<Integer> st = new TreeSet<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int index = 0; index < rains.length; ++index) {
            if (rains[index] == 0) {
                st.add(index);
            } else {
                ans[index] = -1;
                if (mp.containsKey(rains[index])) {
                    Integer it = st.ceiling(mp.get(rains[index]));
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[index];
                    st.remove(it);
                }
                mp.put(rains[index], index);
            }
        }
        return ans;
    }
}
