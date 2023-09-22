package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {

        int length = coins.length;

        List<List<Integer>> connectRelation = new ArrayList<>();
        for (int index = 0; index < length; ++index) {
            connectRelation.add(new ArrayList<>());
        }

        int[] degree = new int[length];
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            connectRelation.get(node1).add(node2);
            connectRelation.get(node2).add(node1);
            ++degree[node1];
            ++degree[node2];
        }

        int remainNodeCount = removeSuperabundance(length, degree, connectRelation, coins);

        Queue<Integer> queue;
        for (int x = 0; x < 2; ++x) {
            queue = new ArrayDeque<>();
            for (int index = 0; index < length; ++index) {
                // 有硬币的叶子节点
                if (degree[index] == 1) {
                    queue.offer(index);
                }
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                --degree[node];
                --remainNodeCount;
                for (int neighbour : connectRelation.get(node)) {
                    --degree[neighbour];
                }
            }
        }

        return remainNodeCount == 0 ? 0 : (remainNodeCount - 1) * 2;
    }

    private int removeSuperabundance(int nodeCount, int[] degree, List<List<Integer>> connectRelation, int[] coins) {
        int remainNodeCount = nodeCount;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int index = 0; index < nodeCount; ++index) {
            if (degree[index] == 1 && coins[index] == 0) {
                queue.offer(index);
            }
        }

        while (!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            --degree[nodeIndex];
            --remainNodeCount;
            for (int neighbour : connectRelation.get(nodeIndex)) {
                --degree[neighbour];
                if (degree[neighbour] == 1 && coins[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return remainNodeCount;
    }
}
