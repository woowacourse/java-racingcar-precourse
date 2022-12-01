package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.Message;

public class OutputView {

    public static final String CAR_FORMAT = "%s : %s\n";
    public static final String MOVE_UNIT = "-";
    public static final String DELIMITER = ", ";
    public static final String ERROR_SUFFIX = "[ERROR]";
    public static final String WINNER_FORMAT = "최종 우승자 : %s";
    public static final String ERROR_FORMAT = "%s %s\n";

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printRaceStart() {
        System.out.println(Message.OUTPUT_RACE_RESULT);
    }

    private void printCar(Car car) {
        System.out.printf(CAR_FORMAT, car.getName(), getMove(car.getCurrentPosition()));
    }

    private String getMove(int currentPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            stringBuilder.append(MOVE_UNIT);
        }
        return stringBuilder.toString();
    }

    public void printWinners(List<String> winners) {
        String winnersName = String.join(DELIMITER, winners);
        System.out.printf(WINNER_FORMAT, winnersName);
    }

    public void printError(String errorMessage) {
        System.out.printf(ERROR_FORMAT, ERROR_SUFFIX, errorMessage);
    }
}
