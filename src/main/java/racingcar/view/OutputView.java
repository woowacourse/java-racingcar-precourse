package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class OutputView {
    private static final String TRIAL_RESULT = "실행 결과";
    private static final String CAR_NAME_PRINT_FORMAT = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자: ";

    public static void printTrialResultFormat() {
        System.out.println();
        System.out.println(TRIAL_RESULT);
    }

    public static void printCarName(Car car) {
        String carName = car.getName();
        System.out.print(carName + CAR_NAME_PRINT_FORMAT);
    }

    public static void printPosition(Car car) {
        int carPosition = car.getPosition();
        StringBuilder printCurrentPosition = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            printCurrentPosition.append(POSITION_INDICATOR);
        }
        System.out.println(printCurrentPosition.toString());
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print(WINNER_ANNOUNCEMENT);
        StringBuilder announcement = new StringBuilder();
        for (String winner : winners) {
            if (announcement.length() > 0) {
                announcement.append(", ");
            }
            announcement.append(winner);
        }
        System.out.println(announcement.toString());
    }
}
