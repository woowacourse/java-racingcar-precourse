package racingcar;

import static racingcar.StringConstants.MIN_VALUE_OF_ROUND_NUMBER;

import java.util.List;

public class RacingGame {
    public int roundNumber;
    private final CarRepository carRepository;

    public RacingGame(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> createCars(String[] names) {
        for (String name : names) {
            Car car = Car.create(name);
            carRepository.saveInOrder(car);
        }
        return findSavedCars();
    }

    public int createRoundNumber(int input) {
        validateRoundNumber(input);
        roundNumber = input;
        return input;
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> findSavedCars() {
        return carRepository.findAllCarsInOrder();
    }
}

