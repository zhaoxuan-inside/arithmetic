package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class topic_2136 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int length = growTime.length;

        Integer[] indices = IntStream.range(0, length).boxed().toArray(Integer[]::new);

        Arrays.sort(indices, (i, j) -> growTime[j] - growTime[i]);

        int curTime = 0;
        int bloomTime = 0;
        for (int index : indices) {
            curTime += plantTime[index];
            bloomTime = Math.max(bloomTime, curTime + growTime[index] + 1);
        }
        return bloomTime - 1;
    }

}
