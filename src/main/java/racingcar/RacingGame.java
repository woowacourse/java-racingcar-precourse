package racingcar;

import static racingcar.StringConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final CarRepository carRepository;
    private int numberOfRounds;

    public RacingGame(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> createCars(String[] names) {
        for (String name : names) {
            Car car = Car.create(name);
            carRepository.saveInOrder(car);
        }
        return findCars();
    }

    public int createNumberOfRounds(int number) {
        validateRoundNumber(number);
        numberOfRounds = number;
        return number;
    }

    public void start() {
        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {
            startEachRound();
            showGameResult();
        }
    }

    private void showGameResult() {
        RacingResultsView racingResultsView = new RacingResultsView(findCars());
        racingResultsView.print();
    }

    private void determineWinners() {
        List<Car> topByOrderByPosition = carRepository.findTopByOrderByPosition();
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> findCars() {
        return carRepository.findAllCarsInOrder();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }

    private void startEachRound() {
        for (Car car : findCars()) {
            car.run(generateRandomNumber());
        }
    }

   
}

