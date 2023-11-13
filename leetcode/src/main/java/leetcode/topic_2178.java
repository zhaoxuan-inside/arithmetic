package leetcode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_2178 {
    public List<Long> maximumEvenSplit(long finalSum) {

        List<Long> result = new ArrayList<>();

        if (finalSum / 2 == 1) {
            return result;
        }

        long currNum = 2L;
        while (finalSum > 0) {

            finalSum = finalSum - currNum;
            if (finalSum <= currNum) {
                currNum += finalSum;
                result.add(currNum);
                return result;
            }

            result.add(currNum);
            currNum += 2;

        }

        return result;

    }
}
