package leetcode;

public class topic_0645 {
    public int[] findErrorNums(int[] nums) {
        int repeatNum = 0;
        int requireNum = 0;
        int[] ints = new int[nums.length];

        for (int num : nums) {
            if (ints[num - 1] != 0) {
                repeatNum = num;
            } else {
                ints[num - 1] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (ints[i] == 0){
                requireNum = i + 1;
            }
        }

        return new int[] {repeatNum, requireNum};

    }
}