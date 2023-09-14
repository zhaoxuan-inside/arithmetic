package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        Set<Integer> queenPositions = new HashSet<>();
        for (int[] queen : queens) {
            int row = queen[0];
            int col = queen[1];
            queenPositions.add(row * 8 + col);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int row = -1; row <= 1; ++row) {
            for (int col = -1; col <= 1; ++col) {

                if (row == 0 && col == 0) {
                    continue;
                }

                int horizontal = king[0] + row;
                int perpendicular = king[1] + col;

                while (horizontal >= 0 &&
                        horizontal < 8 &&
                        perpendicular >= 0 &&
                        perpendicular < 8) {

                    int position = horizontal * 8 + perpendicular;
                    if (queenPositions.contains(position)) {
                        List<Integer> posList = new ArrayList<>();
                        posList.add(horizontal);
                        posList.add(perpendicular);
                        ans.add(posList);
                        break;
                    }

                    horizontal += row;
                    perpendicular += col;
                }
            }
        }
        return ans;
    }
}
