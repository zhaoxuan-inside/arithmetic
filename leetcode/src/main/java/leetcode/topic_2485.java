package leetcode;

@SuppressWarnings("unused")
public class topic_2485 {
    public int pivotInteger(int n) {

        int left = 0;
        int right = 0;
        int leftIndex = 1;
        int rightIndex = n;

        while (leftIndex < rightIndex) {
            if (left < right) {
                left += leftIndex++;
            } else {
                right += rightIndex--;
            }
        }

        if (left == right) {
            return left;
        } else {
            return -1;
        }

    }
}
