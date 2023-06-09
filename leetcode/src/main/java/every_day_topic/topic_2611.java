package every_day_topic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class topic_2611 {

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {


        List<Integer> rewords = Arrays.stream(reward1)
                .boxed()
                .sorted((num1, num2) -> num2 - num1)
                .collect(Collectors.toList())
                .subList(0, k);

        int[] dispatch = new int[reward1.length];

        int index = 0;
        for (int i = 0; i < reward1.length; i++) {

            if (rewords.contains(reward1[i]) && index < k) {
                dispatch[i] = reward1[i];
                index++;
            } else {
                dispatch[i] = reward2[i];
            }

        }

        return Arrays.stream(dispatch).sum();

    }

    public static void main(String[] args) {
        System.out.println(miceAndCheese(
                new int[]{
                        4,1,5,3,3
                },
                new int[]{
                        3,4,4,5,2
                },
                3

        ));

    }

}
