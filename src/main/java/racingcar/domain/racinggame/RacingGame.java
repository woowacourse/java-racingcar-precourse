package racingcar.domain.racinggame;

import racingcar.domain.car.CarMovement;
import racingcar.domain.car.Cars;
import racingcar.domain.trynumber.TryNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public List<Cars> play(CarMovement carMovement) {
        int tryNumberValue = tryNumber.getValue();

        return Stream.generate(() -> updateCars(carMovement))
                .limit(tryNumberValue)
                .collect(Collectors.toList());
    }

    private Cars updateCars(CarMovement carMovement) {
        this.cars = this.cars.moveAllForwardOrStop(carMovement);
        return this.cars;
    }
}
