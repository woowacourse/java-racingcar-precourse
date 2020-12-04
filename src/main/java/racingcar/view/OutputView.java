package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String DELIMITER_COLON = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String DELIMITER_COMMA = ", ";
    private static final String WINNER_INFO_MESSAGE = "최종 우승자: ";
    private static final String ACTION_RESULT_MESSAGE = "실행 결과";

    public static void printWinners(List<Car> winners) {
        System.out.print(WINNER_INFO_MESSAGE);
        String printWinner = winners.stream()
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(printWinner);
    }

    public static void printProcess(List<Cars> processes) {
        System.out.println(ACTION_RESULT_MESSAGE);
        processes.stream()
                .forEach(cars -> printCars(cars));
    }

    private static void printCars(Cars cars) {
        cars.getValue().stream()
                .forEach(car -> printCarPosition(car));
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getName().getValue() + DELIMITER_COLON + convertToPositionSymbols(car.getPosition()));
    }

    private static String convertToPositionSymbols(int position) {
        return Stream.generate(() -> POSITION_SYMBOL)
                .limit(position)
                .collect(Collectors.joining());
    }
}
