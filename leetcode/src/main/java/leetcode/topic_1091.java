package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class topic_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int length = grid.length;
        int result = -1;
        int path = 0;

        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
            return result;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            Queue<int[]> layoutQueue = new LinkedList<>();

            while (!queue.isEmpty()){
                layoutQueue.offer(queue.peek());
            }

            if (!layoutQueue.isEmpty()) {
                path++;
            }

            while (!layoutQueue.isEmpty()) {
                int[] peek = layoutQueue.peek();

                int row = peek[0];
                int col = peek[1];

                grid[row][col] = 1;

                if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0) {
                    queue.offer(new int[] {row - 1, col - 1});
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                    queue.offer(new int[] {row - 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                    queue.offer(new int[] {row, col - 1});
                }
                if (row + 1 < length && grid[row + 1][col] == 0) {
                    queue.offer(new int[] {row + 1, col});
                }
                if (col + 1 < length && grid[row][col + 1] == 0) {
                    queue.offer(new int[] {row, col + 1});
                }
                if (row + 1 < length && col + 1 < length && grid[row + 1][col + 1] == 0) {
                    queue.offer(new int[] {row + 1, col + 1});
                }

                if (row + 1 == length - 1 && col + 1 == length - 1) {
                    return path + 1;
                }
            }
        }

        return result;
    }
}