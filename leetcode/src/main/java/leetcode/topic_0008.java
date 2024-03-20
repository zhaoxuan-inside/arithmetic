package leetcode;


@SuppressWarnings("unused")
public class topic_0008 {

    public static int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.charHandler(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

}

enum StateSwitchEnum {
    START("START", new String[]{"START", "SIGNED", "IN_NUMBER", "END"}),
    SIGNED("SIGNED", new String[]{"END", "END", "IN_NUMBER", "END"}),
    IN_NUMBER("IN_NUMBER", new String[]{"END", "END", "IN_NUMBER", "END"}),
    END("END", new String[]{"END", "END", "END", "END"});

    private final String state;
    private final String[] nextStat;

    StateSwitchEnum(String state, String[] nextState) {
        this.state = state;
        this.nextStat = nextState;
    }

    public String getState() {
        return state;
    }

    public String[] getNextState() {
        return nextStat;
    }

    public static StateSwitchEnum getByState(String state) {
        for (StateSwitchEnum value : StateSwitchEnum.values()) {
            if (value.getState().equals(state)) {
                return value;
            }
        }
        return null;
    }

    public static StateSwitchEnum getNextState(StateSwitchEnum state, int idx) {
        return getByState(state.getNextState()[idx]);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private StateSwitchEnum state = StateSwitchEnum.START;

    public void charHandler(char c) {
        state = StateSwitchEnum.getNextState(state, getNextStateIdx(c));
        if (StateSwitchEnum.IN_NUMBER.equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if (StateSwitchEnum.SIGNED.equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int getNextStateIdx(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

}
