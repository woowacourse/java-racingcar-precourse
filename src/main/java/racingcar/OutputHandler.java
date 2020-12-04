package racingcar;

import java.util.List;

import utils.StringUtils;

public class OutputHandler {
    private static final String RUN_MESSAGE = "\n실행 결과";
    private static final String NAME_TAG = "%s : ";
    private static final Character PROGRESS_BAR = '-';

    private static final String WINNER_IS = "최종 우승자: ";
    private static final String DELIMITER = ", ";

    private OutputHandler() {}

    public static void printRunMessage() {
        System.out.println(RUN_MESSAGE);
    }

    public static void printCarList(CarList carList) {
        for (Car car : carList) {
            printCar(car);
        }

        printEmptyLine();
    }
    
    private static void printCar(Car car) {
        printCarName(car.getName());
        printPosition(car.getPosition());
        printEmptyLine();
    }
    
    private static void printCarName(String carName) {
        System.out.printf(NAME_TAG, carName);
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(PROGRESS_BAR);
        }
    }
    
    private static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNER_IS);
        System.out.println(StringUtils.join(winners, DELIMITER));
    }
}
