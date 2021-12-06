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

public class RacingGameService {
    private final CarRepository carRepository;
    private RacingGame racingGame;

    public RacingGameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarsReady(String[] carNames) {
        List<Car> cars = createCars(carNames);
        checkDuplicateCars(cars);
        saveCarsInOrder(cars);
        return findCarsInOrder();
    }

    public void getRacingGameReady(int numberOfRounds) {
        racingGame = RacingGame.create(numberOfRounds);
    }

    public RacingGameResult start() {
        while (!racingGame.isOver()) {
            startEachRound();
            completeEachRound();
            recordEachRoundResult();
        }
        return findGameResult();
    }

    public List<Car> determineWinners() {
        return carRepository.findTopByOrderByPosition();
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carsToSave = new ArrayList<>();
        for (String carName : carNames) {
            carsToSave.add(Car.create(carName));
        }
        return carsToSave;
    }

    private void checkDuplicateCars(List<Car> cars) {
        Set<Car> notDuplicatedCars = new HashSet<>(cars);
        if (notDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_DUPLICATED_CAR_NAMES_INPUT);
        }
    }

    private void saveCarsInOrder(List<Car> cars) {
        carRepository.saveInOrder(cars);
    }

    private List<Car> findCarsInOrder() {
        return carRepository.findAllInOrder();
    }

    private void startEachRound() {
        for (Car car : findCarsInOrder()) {
            car.run(generateRandomNumber());
        }
    }

    private void completeEachRound() {
        racingGame.completeOneRound();
    }

    private void recordEachRoundResult() {
        racingGame.recordRacingResults(findCarsInOrder());
    }

    private RacingGameResult findGameResult() {
        return racingGame.showGameResult();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }
}
