package racingcar;

import static racingcar.utils.StringConstants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.view.RacingResultsView;

public class RacingGame {
    private final CarRepository carRepository;
    private int numberOfRounds;

    public RacingGame(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> carsToSave = new ArrayList<>();
        for (String carName : carNames) {
            carsToSave.add(Car.create(carName));
        }
        carRepository.saveInOrder(carsToSave);
        return findCarsInOrder();
    }

    public void createNumberOfRounds(int number) {
        validateRoundNumber(number);
        numberOfRounds = number;
    }

    public List<Car> start() {
        for (int roundNumber = MIN_VALUE_OF_ROUND_NUMBER; roundNumber <= numberOfRounds; roundNumber++) {
            startEachRound();
            printRacingResults();
        }
        return determineWinners();
    }

    private void printRacingResults() {
        RacingResultsView racingResultsView = new RacingResultsView(findCarsInOrder());
        racingResultsView.print();
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> findCarsInOrder() {
        return carRepository.findAllInOrder();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }

    private void startEachRound() {
        for (Car car : findCarsInOrder()) {
            car.run(generateRandomNumber());
        }
    }

    private List<Car> determineWinners() {
        return carRepository.findTopByOrderByPosition();
    }
}

