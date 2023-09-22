package every_day_topic;

@SuppressWarnings("unused")
public class topic_2591 {
    public static int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        int remainMoney = money - children;
        int maxEightChildren = remainMoney / 7;
        int allocateEightRemain = remainMoney % 7;
        if (maxEightChildren == children) {
            if (allocateEightRemain == 0) {
                return children;
            } else {
                return children - 1;
            }
        }

        if (maxEightChildren > children) {
            return children - 1;
        }

        if (children - maxEightChildren == 1 && allocateEightRemain == 3) {
            return maxEightChildren - 1;
        }

        return maxEightChildren;

    }

}
