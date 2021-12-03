package racingcar;

import static racingcar.StringConstants.MIN_VALUE_OF_ROUND_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<Car> createCars(String[] carNameStrings) {
        List<Car> carNames = new ArrayList<>();
        for (String carNameString : carNameStrings) {
            carNames.add(Car.create(carNameString));
        }
        return carNames;
    }

    public int createRoundNumber(int input) {
        validateRoundNumber(input);
        return input;
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
