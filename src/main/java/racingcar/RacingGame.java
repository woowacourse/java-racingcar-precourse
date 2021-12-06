package racingcar;

import static racingcar.utils.StringUtils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.gameresult.RacingGameResult;
import racingcar.gameresult.RacingResults;

public class RacingGame {
    private final CarRepository carRepository;
    private int numberOfRounds;
    private RacingGameResult racingGameResult;

    public RacingGame(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarsReady(String[] carNames) {
        List<Car> cars = createCars(carNames);
        checkDuplicateCars(cars);
        carRepository.saveInOrder(cars);
        return findCarsInOrder();
    }

    public void setNumberOfRounds(int number) {
        validateRoundNumber(number);
        numberOfRounds = number;
        setRacingGameResult();
    }

    public RacingGameResult start() {
        for (int roundNumber = MIN_VALUE_OF_ROUND_NUMBER; roundNumber <= numberOfRounds; roundNumber++) {
            startEachRound();
            recordRacingResults();
        }
        return racingGameResult;
    }

    public List<Car> determineWinners() {
        return carRepository.findTopByOrderByPosition();
    }

    private void checkDuplicateCars(List<Car> cars) {
        Set<Car> notDuplicatedCars = new HashSet<>(cars);
        if (notDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_DUPLICATED_CAR_NAMES_INPUT);
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carsToSave = new ArrayList<>();
        for (String carName : carNames) {
            carsToSave.add(Car.create(carName));
        }
        return carsToSave;
    }

    private List<Car> findCarsInOrder() {
        return carRepository.findAllInOrder();
    }

    private void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void setRacingGameResult() {
        racingGameResult = new RacingGameResult(numberOfRounds);
    }

    private void startEachRound() {
        for (Car car : findCarsInOrder()) {
            car.run(generateRandomNumber());
        }
    }

    private void recordRacingResults() {
        racingGameResult.add(new RacingResults(findCarsInOrder()));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }
}

