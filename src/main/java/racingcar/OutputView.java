package racingcar;

import java.util.List;

public class OutputView {

    public static final String CAR_FORMAT = "%s : %s";
    public static final String MOVE_UNIT = "-";

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.printf(CAR_FORMAT, car.getName(), getMove(car.getCurrentPosition()));
        printNewLine();
    }

    private String getMove(int currentPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            stringBuilder.append(MOVE_UNIT);
        }
        return stringBuilder.toString();
    }
}
