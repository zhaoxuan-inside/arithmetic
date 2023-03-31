package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class interview_08_13 {
    public static int pileBox(int[][] boxs) {
        int[] highs = new int[boxs.length];
        int maxHigh = 0;

        Arrays.sort(boxs, Comparator.comparingInt(num -> num[0]));

        for (int button = 0; button < boxs.length; button++){
            for (int top = 0; top < button; top++){
                if (boxs[button][0] > boxs[top][0] &&
                        boxs[button][1] > boxs[top][1] &&
                        boxs[button][2] > boxs[top][2]){

                    // up箱子可以摞到low箱子上面，对比以up箱子为底和以low箱子为底摞出来的高度对比
                    highs[button] = Math.max(highs[button], highs[top]);

                }
            }

            highs[button] += boxs[button][2];

            maxHigh = Math.max(maxHigh, highs[button]);
        }

        return maxHigh;
    }

    public static void main(String[] args) {
        int [][] nums = {{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}};

        System.out.println(pileBox(nums));
    }
}