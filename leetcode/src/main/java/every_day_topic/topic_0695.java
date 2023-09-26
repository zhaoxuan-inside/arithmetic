package every_day_topic;

import java.util.*;

@SuppressWarnings("unused")
public class topic_0695 {

    private static int[][] array = new int[1][];
    private static int rowLen = 0;
    private static int colLen = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        array = grid;
        rowLen = array.length;
        colLen = array[0].length;

        int max = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int sign = array[row][col];

                if (sign == 1) {
                    int currMax = findIsland(row, col);
                    max = Math.max(max, currMax);
                }

            }
        }

        return max;

    }

    private static int findIsland(int row, int col) {
        int subAns = 2;

        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> node = new ArrayList<>();
        node.add(row);
        node.add(col);
        stack.push(node);

        array[row][col] = 2;

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int currRow = pop.get(0);
            int currCol = pop.get(1);

            if (currRow > 0 && array[currRow - 1][currCol] == 1) {
                subAns++;
                array[currRow - 1][currCol] = subAns;
                List<Integer> currNode = new ArrayList<>();
                currNode.add(currRow - 1);
                currNode.add(currCol);
                stack.push(currNode);
            }
            if (currRow < rowLen - 1 && array[currRow + 1][currCol] == 1) {
                subAns++;
                array[currRow + 1][currCol] = subAns;
                List<Integer> currNode = new ArrayList<>();
                currNode.add(currRow + 1);
                currNode.add(currCol);
                stack.push(currNode);
            }
            if (currCol > 0 && array[currRow][currCol - 1] == 1) {
                subAns++;
                array[currRow][currCol - 1] = subAns;
                List<Integer> currNode = new ArrayList<>();
                currNode.add(currRow);
                currNode.add(currCol - 1);
                stack.push(currNode);
            }
            if (currCol < colLen - 1 && array[currRow][currCol + 1] == 1) {
                subAns++;
                array[currRow][currCol + 1] = subAns;
                List<Integer> currNode = new ArrayList<>();
                currNode.add(currRow);
                currNode.add(currCol + 1);
                stack.push(currNode);
            }
        }
        return subAns - 1;
    }

}
