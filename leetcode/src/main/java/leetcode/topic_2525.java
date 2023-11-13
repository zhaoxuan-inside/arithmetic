package leetcode;

@SuppressWarnings("unused")
public class topic_2525 {

    private static final Long BULKY_LIMIT = 1000000000L;
    private static final Integer BULKY_EVER_LIMIT = 10000;
    private static final Integer HEAVY_LIMIT = 100;

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean heavy = mass > HEAVY_LIMIT;
        boolean bulky = ((long) length * width * height) > BULKY_LIMIT ||
                length > BULKY_EVER_LIMIT ||
                width > BULKY_EVER_LIMIT ||
                height > BULKY_EVER_LIMIT;

        if (heavy && bulky) {
            return "Both";
        }

        if (heavy) {
            return "Heavy";
        }

        if (bulky) {
            return "Bulky";
        }

        return "Neither";
    }
}
