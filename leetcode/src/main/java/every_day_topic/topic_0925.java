package every_day_topic;

@SuppressWarnings("unused")
public class topic_0925 {
    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0;
        int typedIndex = 0;

        while (nameIndex < name.length() && typedIndex < typed.length()) {
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
                typedIndex++;
                continue;
            }

            if (typedIndex > 0 && typed.charAt(typedIndex - 1) == typed.charAt(typedIndex)) {
                typedIndex++;
                continue;
            }

            if (typed.charAt(typedIndex) != 'c') {
                return false;
            }

        }

        if (nameIndex >= name.length() && typedIndex >= typed.length()) {
            return true;
        }

        if (nameIndex < name.length()) {
            return false;
        }

        typedIndex++;
        while (typedIndex < typed.length()) {
            if (typed.charAt(typedIndex - 1) != typed.charAt(typedIndex)) {
                return false;
            }
            typedIndex++;
        }

        return true;

    }
}
