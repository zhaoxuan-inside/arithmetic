package every_day_topic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class topic_1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();

        for (int sum : colsum) {
            switch (sum) {
                case 0:
                    upperList.add(0);
                    lowerList.add(0);
                    break;
                case 1:
                    if (upper > lower) {
                        if (upper <= 0) {
                            return result;
                        }
                        upperList.add(1);
                        lowerList.add(0);
                        upper--;
                    } else {
                        if (lower <= 0) {
                            return result;
                        }
                        upperList.add(0);
                        lowerList.add(1);
                        lower--;
                    }
                    break;
                case 2:
                    if (upper <= 0 || lower <= 0) {
                        return result;
                    }
                    upperList.add(1);
                    lowerList.add(1);
                    upper--;
                    lower--;
                    break;

            }
        }

        if (upper > 0 || lower > 0) {
            return result;
        }

        result.add(upperList);
        result.add(lowerList);

        return result;

    }

}
