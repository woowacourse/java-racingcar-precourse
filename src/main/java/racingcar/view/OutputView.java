package racingcar.view;

import racingcar.domain.car.Car;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String DELIMITER_COLON = " : ";
    private static final String EACH_POSITION_SYMBOL = "-";

    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + DELIMITER_COLON + convertToPositionSymbols(car.getPosition()));
    }

    private static String convertToPositionSymbols(int position) {
        return Stream.generate(() -> EACH_POSITION_SYMBOL)
                .limit(position)
                .collect(Collectors.joining());
    }
}
