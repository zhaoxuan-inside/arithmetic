package every_day_topic;

@SuppressWarnings("unused")
public class topic_1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        if (xCenter < x1 && yCenter < y1) {

            return Math.sqrt(
                    Math.pow((x1 - xCenter), 2) + Math.pow((y1 - yCenter), 2)
            ) <= radius;

        }

        if (xCenter < x1 && yCenter > y2) {

            return Math.sqrt(
                    Math.pow((x1 - xCenter), 2) + Math.pow((y2 - yCenter), 2)
            ) <= radius;

        }

        if (xCenter < x1) {

            return Math.abs(
                    x1 - xCenter
            ) <= radius;

        }

        if (xCenter > x2 && yCenter < y1) {

            return Math.sqrt(
                    Math.pow((x2 - xCenter), 2) + Math.pow((y1 - yCenter), 2)
            ) <= radius;

        }

        if (xCenter > x2 && yCenter > y2) {

            return Math.sqrt(
                    Math.pow((x2 - xCenter), 2) + Math.pow((y2 - yCenter), 2)
            ) <= radius;

        }

        if (xCenter > x2) {

            return Math.abs(
                    x2 - xCenter
            ) <= radius;

        }

        if (yCenter > y2) {

            return Math.abs(
                    y2 - yCenter
            ) <= radius;

        }

        if (yCenter < y1) {

            return Math.abs(
                    y1 - yCenter
            ) <= radius;

        }

        return true;

    }

}
