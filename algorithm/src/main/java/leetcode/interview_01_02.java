package leetcode;

import java.util.Arrays;

public class interview_01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars1);

        for (int i = 0; i < s1.length() ; i++) {
            if (chars1[i] != chars2[i]){
                return false;
            }
        }

        return true;
    }
}
