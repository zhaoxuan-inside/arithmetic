package every_day_topic;

@SuppressWarnings("unused")
public class topic_2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        if (numOnes >= k) {
            return k;
        }

        if (numZeros + numOnes >= k) {
            return numOnes;
        }

        if (numZeros + numNegOnes + numOnes >= k) {
            return numOnes + -1 * (k - numZeros - numOnes);
        }

        return numOnes + -1 * numNegOnes;

    }
}
