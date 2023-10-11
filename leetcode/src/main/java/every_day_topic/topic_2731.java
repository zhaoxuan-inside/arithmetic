package every_day_topic;

import java.util.Arrays;

@SuppressWarnings("unused")
public class topic_2731 {

    private final int MOD = (int) Math.pow(10, 9) + 7;
    private int[] dirs;
    private char[] defaultDirs;

    public int sumDistance(int[] nums, String s, int d) {

        int length = nums.length;
        dirs = new int[length];
        defaultDirs = s.toCharArray();
        int robotCount = defaultDirs.length;

        for (int index = 0; index < d; index++) {
            for (int robot = 0; robot < robotCount; robot++) {
                if (dirs[robot] == 0) {
                    switch (defaultDirs[robot]) {
                        case 'R':
                            nums[robot]++;
                            break;
                        case 'L':
                            nums[robot]--;
                            break;
                    }
                } else {
                    switch (dirs[robot]) {
                        case -1:
                            nums[robot]--;
                            break;
                        case 1:
                            nums[robot]++;
                            break;
                    }
                }
            }

            for (int robot = 0; robot < robotCount; robot++) {
                for (int otherRobot = robot + 1; otherRobot < robotCount; otherRobot++) {
                    if (robot != otherRobot) {
                        if (nums[robot] == nums[otherRobot]) {
                            reverseDir(robot);
                            reverseDir(otherRobot);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int robot = 0; robot < robotCount; robot++) {
            for (int otherRobot = robot + 1; otherRobot < robotCount; otherRobot++) {
                int gap = Math.abs(nums[robot] - nums[otherRobot]);
                gap %= MOD;
                ans = (ans + gap) % MOD;
            }
        }

        return ans;

    }

    private void reverseDir(int index) {
        if (dirs[index] == 0) {
            if (defaultDirs[index] == 'R') {
                dirs[index] = -1;
            } else {
                dirs[index] = 1;
            }
        } else {
            dirs[index] *= -1;
        }
    }

    static class Faster {
        static final int MOD = 1000000007;

        public int sumDistance(int[] nums, String s, int d) {
            int length = nums.length;
            long[] pos = new long[length];
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == 'L') {
                    pos[i] = (long) nums[i] - d;
                } else {
                    pos[i] = (long) nums[i] + d;
                }
            }
            Arrays.sort(pos);
            long res = 0;
            for (int index = 1; index < length; index++) {
                res += (pos[index] - pos[index - 1]) * index % MOD * (length - index) % MOD;
                res %= MOD;
            }
            return (int) res;
        }
    }

}
