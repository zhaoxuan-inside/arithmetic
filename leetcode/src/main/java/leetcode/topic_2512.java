package leetcode;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class topic_2512 {

    private static class Student {
        int id;
        int score;
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        Set<String> positives = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negatives = new HashSet<>(Arrays.asList(negative_feedback));

        int length = report.length;
        Student[] scores = new Student[length];

        for (int index = 0; index < length; index++) {
            scores[index] = new Student();
            scores[index].id = student_id[index];
            for (String word : report[index].split(" ")) {
                if (positives.contains(word)) {
                    scores[index].score += 3;
                }
                if (negatives.contains(word)) {
                    scores[index].score -= 1;
                }
            }
        }

        return Arrays.stream(scores)
                .sorted((stu1, stu2) -> {
                    if (stu2.score > stu1.score) {
                        return -1;
                    }
                    if (stu2.score == stu1.score) {
                        return stu1.id - stu2.id;
                    }
                    return 1;
                })
                .map(student -> student.id)
                .collect(Collectors.toList()).subList(0, Math.min(k, length));

    }

}
