package racingcar.views;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;

public class OutputView {
    private static final String RESULT_GUIDING_MESSAGE = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자";
    private static final String DISTANCE = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static void printCurrentStatus(RacingGame racingGame) {
        racingGame.getCars().forEach(OutputView::printCarStatus);
        printMessageAndNewLine(BLANK);
    }

    private static void printCarStatus(Car car) {
        String statusMessage = car.getName() + COLON + getDistanceBar(car);
        printMessageAndNewLine(statusMessage);
    }

    private static String getDistanceBar(Car car) {
        StringBuilder distanceBar = new StringBuilder();
        int distance = car.getPosition();
        for (int i = 0; i < distance; i++) {
            distanceBar.append(DISTANCE);
        }
        return distanceBar.toString();
    }

    public static void printWinners(Winners winners) {
        String finalWinners = FINAL_WINNERS + COLON + String.join(COMMA, winners.getWinners());
        printMessageAndNewLine(finalWinners);
    }

    public static void printResultGuidingMessage() {
        printMessageAndNewLine(RESULT_GUIDING_MESSAGE);
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}
