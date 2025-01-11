package leetcode;

import java.util.ArrayList;
import java.util.List;

public class topic_0729 {

}

class MyCalendar {

    private List<List<Integer>> lists;

    public MyCalendar() {
        lists = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        List<Integer> curr = new ArrayList<>();
        curr.add(startTime);
        curr.add(endTime);

        for (int idx = 0; idx < lists.size(); idx++) {

            List<Integer> timeGap = lists.get(idx);

            if (contain(timeGap, curr) < 0) {
                lists.add(idx, curr);
                return true;
            }

            if (contain(timeGap, curr) == 0) {
                return false;
            }

        }

        lists.add(curr);
        return true;

    }

    private int contain(List<Integer> list1, List<Integer> list2) {
        if (list2.get(1) <= list1.get(0)) {
            return -1;
        }

        if (list2.get(0) >= list1.get(1)) {
            return 1;
        }

        return 0;
    }

}
