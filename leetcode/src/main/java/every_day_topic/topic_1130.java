package every_day_topic;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_1130 {

    public static int mctFromLeafValues(int[] arr) {

        int result = 0;

        List<Integer> arrList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        List<Integer> productList = new ArrayList<>(arrList);

        int index = 0;
        while (arrList.size() > 1) {

            Integer arrList1 = arrList.get(index);
            Integer arrList2 = arrList.get(index + 1);

            Integer productList1 = productList.get(index);
            Integer productList2 = productList.get(index + 1);

            for (int i = 0; i < 2; i++) {
                arrList.remove(index);
                productList.remove(index);
            }

            int arrListProduct = productList1 * productList2;
            int product = Math.max(arrList1, arrList2);

            for (int i = 0; i <= arrList.size(); i++) {

                if (i == arrList.size() || arrList.get(i) > arrListProduct) {
                    arrList.add(i, arrListProduct);
                    productList.add(i, product);
                    break;
                }

            }

            result += arrListProduct;

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(mctFromLeafValues(new int[]{4, 11, 8, 3, 9, 1}));
    }

}
