package leetcode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int halfMaxValue = Integer.MAX_VALUE / 2;
        int[] ans = {halfMaxValue, -1};
        int[][] distances = new int[n][n];
        for (int idx = 0; idx < n; ++idx) {
            Arrays.fill(distances[idx], halfMaxValue);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distances[from][to] = weight;
            distances[to][from] = weight;
        }
        for (int mid = 0; mid < n; ++mid) {
            distances[mid][mid] = 0;
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    distances[row][col] = Math.min(distances[row][col], distances[row][mid] + distances[mid][col]);
                }
            }
        }
        for (int row = 0; row < n; ++row) {
            int connect = 0;
            for (int col = 0; col < n; ++col) {
                if (distances[row][col] <= distanceThreshold) {
                    connect++;
                }
            }
            if (connect <= ans[0]) {
                ans[0] = connect;
                ans[1] = row;
            }
        }
        return ans[1];
    }

}
