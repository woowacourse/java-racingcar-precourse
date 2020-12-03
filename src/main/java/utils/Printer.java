package utils;

import domain.Car;

import java.util.List;

public class Printer {
    private static final String CURRENT_POSITION = "%s : %s";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "최종 우승자: %s";
    private static final String DELIMITER_FOR_WINNER = ", ";
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private static final char LINE = '-';

    public static void printCurrentPosition(Car car) {
        String name = car.getName();
        int position = car.getCurrentPosition();
        String graph = convertToGraph(position);
        System.out.println(String.format(CURRENT_POSITION, name, graph));
    }

    private static String convertToGraph(int position) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < position; i++) {
            graph.append(LINE);
        }
        return graph.toString();
    }

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
        System.out.println(String.format(RACE_WINNER_MESSAGE, winnerName));
    }

    public static void printErrorMessage(String error){
        System.out.println(String.format(ERROR_MESSAGE, error));
    }
}
