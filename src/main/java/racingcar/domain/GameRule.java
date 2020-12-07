package racingcar.domain;

import java.util.stream.Collectors;

public class GameRule {
    private static final String COMMA_SPACE_DELIMITER = ", ";

    private GameRule() {
    }

    public static String getRacingWinners(Cars cars) {
        return cars.getFastestCars()
                .stream()
                .map(car -> String.valueOf(car.getName()))
                .collect(Collectors.joining(COMMA_SPACE_DELIMITER));
    }
}
