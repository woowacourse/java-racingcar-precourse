package racingcar.domain.result;

public class RoundResult {
    public static String of(String name, int position) {
        return name + " : " + repeat(position);
    }

    private static String repeat(int time) {
        String result = "-";

        if (time == 0)
            return "";

        for (int i = 1; i < time; i++) {
            result += result;
        }
        return result;
    }
}
