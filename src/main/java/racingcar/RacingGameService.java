package racingcar;

import static racingcar.utils.StringUtils.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.gameresult.GameResult;

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

    public GameResult start() {
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
        return Arrays.stream(carNames)
                .map(Car::create)
                .collect(Collectors.toList());
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
        findCarsInOrder().forEach(car -> car.run(generateRandomNumber()));
    }

    private void completeEachRound() {
        racingGame.completeOneRound();
    }

    private void recordEachRoundResult() {
        racingGame.recordRoundResult(findCarsInOrder());
    }

    private GameResult findGameResult() {
        return racingGame.showGameResult();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE_OF_RANDOM_NUMBER, MAX_VALUE_OF_RANDOM_NUMBER);
    }
}
