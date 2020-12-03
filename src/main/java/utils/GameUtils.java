package utils;

public class GameUtils {
    private static final String NAME_OVER_MESSAGE = "[ERROR] 차 이름은 5글자 이하여야 한다.";
    private static final String NUM_OF_RUNS_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    private GameUtils() {
    }

    public static void isCarNameRight(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(NAME_OVER_MESSAGE);
        }
    }

    public static int isNumOfRunsRight(String numberOfRuns) {
        int runs;
        try {
            runs = Integer.parseInt(numberOfRuns);
        } catch (Exception e){
            throw new IllegalArgumentException(NUM_OF_RUNS_NUMBER_MESSAGE);
        }

        return runs;
    }
}
