package leetcode;

@SuppressWarnings("unused")
public class topic_0670 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end++) {
                swap(charArray, start, end);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, start, end);
            }
        }
        return maxNum;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
