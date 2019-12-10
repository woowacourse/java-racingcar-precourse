import domain.Car;
import domain.RacingCars;
import utils.OutputUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private static final Integer EMPTY = 0;

    static List<Car> decideWinners(RacingCars racingCars) {
        Integer maxPosition = getMaxPosition(racingCars);

        if (maxPosition == EMPTY) {
            return new ArrayList<Car>();
        }

        return racingCars.getRacingCars().stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toList());
    }

    private static Integer getMaxPosition(RacingCars racingCars) {
        Car winner = racingCars.getRacingCars().stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        return winner.getPosition();
    }
}
