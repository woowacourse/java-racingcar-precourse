package utils;

public class OutPutPrinter {
    private static final String RACE_RESULT = "실행결과";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String NEW_LINE = "\n";

    public static void carRacingResultPrint(String raceResult) {
        System.out.println(NEW_LINE + RACE_RESULT);
        System.out.println(raceResult);
    }

    public static void carRaceWinnerPrint(String winners) {
        System.out.println(FINAL_WINNER + winners);
    }
}
