package utils;

import java.util.List;

public class OutPutManager {
    private static final String RACE_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String NEW_LINE = "\n";
    private static final String OUTPUT_SEPARATOR = ", ";

    public static void carRacingResultPrint(String raceResult) {
        System.out.println(NEW_LINE + RACE_RESULT);
        System.out.println(raceResult);
    }

    public static void carRaceWinnerPrint(List<String> winners) {
        String winnerPrint = String.join(OUTPUT_SEPARATOR, winners);
        System.out.println(FINAL_WINNER + winnerPrint);
    }
}
