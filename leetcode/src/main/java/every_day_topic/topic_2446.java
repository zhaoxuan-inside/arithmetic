package every_day_topic;

@SuppressWarnings("unused")
public class topic_2446 {
    public static boolean haveConflict(String[] event1, String[] event2) {

        int event1Start = Integer.parseInt(event1[0].replace(":", ""));
        int event1End = Integer.parseInt(event1[1].replace(":", ""));
        int event2Start = Integer.parseInt(event2[0].replace(":", ""));
        int event2End = Integer.parseInt(event2[1].replace(":", ""));

        return Math.max(event1Start, event2Start) <= Math.min(event1End, event2End);

    }

}
