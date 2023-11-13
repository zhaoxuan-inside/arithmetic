package leetcode;

@SuppressWarnings("unused")
public class topic_2481 {
    public int numberOfCuts(int n) {
        return n > 1 ? n % 2 == 0 ? n / 2 : n : 0;
    }
}
