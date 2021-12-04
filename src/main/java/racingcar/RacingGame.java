package racingcar;

import static racingcar.StringConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public int numberOfRounds;
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

    public int createNumberOfRounds(int number) {
        validateRoundNumber(number);
        numberOfRounds = number;
        return number;
    }

    public void start() {
        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {
            playEachRound();
        }
    }

    private void playEachRound() {
        for (Car car : findSavedCars()) {
            car.run(generateRandomNumber());
        }
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> findSavedCars() {
        return carRepository.findAllCarsInOrder();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }
}

