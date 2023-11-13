package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_1333 {

    private static class ResRate {
        public ResRate(int id, int rate) {
            this.id = id;
            this.rate = rate;
        }

        private final int id;
        private final int rate;
    }


    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<ResRate> ans = new ArrayList<>();
        List<int[]> filter = new ArrayList<>();

        int index = 0;
        for (int[] restaurant : restaurants) {
            if (restaurant[2] >= veganFriendly &&
                    restaurant[3] <= maxPrice &&
                    restaurant[4] <= maxDistance) {
                ans.add(new ResRate(restaurant[0], restaurant[1]));
            }
        }

        ans.sort(
                (ans1, ans2) ->
                        ans1.rate == ans2.rate ?
                                ans2.id - ans1.id :
                                ans2.rate - ans1.rate
        );

        return ans.stream().map(ans1 -> ans1.id).collect(Collectors.toList());

    }

}
