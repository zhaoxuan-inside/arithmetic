package every_day_topic;

import java.util.*;

public class topic_1282 {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int index = 0; index < groupSizes.length; index++) {
            int groupSize = groupSizes[index];
            List<List<Integer>> groupPeople = map.get(groupSize);
            if (groupPeople == null) {
                groupPeople = new ArrayList<>();
                map.put(groupSize, groupPeople);
            }

            List<Integer> subGroup = null;
            for (List<Integer> groupPerson : groupPeople) {
                if (groupPerson.size() < groupSize) {
                    subGroup = groupPerson;
                }
            }

            if (subGroup == null) {
                subGroup = new ArrayList<>();
                groupPeople.add(subGroup);
            }

            subGroup.add(index);

        }

        for (Integer groupNo : map.keySet()) {
            result.addAll(map.get(groupNo));
        }

        return result;

    }

}
