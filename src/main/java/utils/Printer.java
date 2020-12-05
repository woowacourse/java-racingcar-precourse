package utils;

import java.util.List;

public class Printer {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "최종 우승자: %s";
    private static final String DELIMITER_FOR_WINNER = ", ";
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

    public static void printRaceStart() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printWinnerName(List<String> names) {
        String winnerName = String.join(DELIMITER_FOR_WINNER, names);
        System.out.print(String.format(RACE_WINNER_MESSAGE, winnerName));
    }

    public static void printErrorMessage(String error) {
        System.out.println(String.format(ERROR_MESSAGE, error));
    }

    public static void print(String content) {
        System.out.print(content);
    }
}
