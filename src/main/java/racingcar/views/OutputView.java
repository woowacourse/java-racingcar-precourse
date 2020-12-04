package racingcar.views;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {
    private static final String RESULT_GUIDING_MESSAGE = "실행 결과";
    private static final String DISTANCE = "-";
    private static final String COLON = " : ";
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

    public static void printResultGuidingMessage() {
        printMessageAndNewLine(RESULT_GUIDING_MESSAGE);
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}
