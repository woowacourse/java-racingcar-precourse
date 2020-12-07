package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameRounds;
import racingcar.service.CarNameTokenizer;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.Collectors;

public class GameController {
    public static final int INDEX_VALUE_MIN = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private GameRounds gameRound;

    GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void registerCars() {
        this.cars = new Cars(CarNameTokenizer.split(inputView.inputCarName())
                .stream()
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList()));
    }

    public void setGameRounds() {
        this.gameRound = new GameRounds(inputView.inputNumberOfAttempts());
    }

    public void startRace() {
        outputView.showGameResult();

        for (int index = INDEX_VALUE_MIN; index < this.gameRound.getRounds(); index++) {
            startEachRound();
            outputView.showEachRoundResult(this.cars);
        }

        outputView.showWinners(this.cars.findWinners());
    }

    public void startEachRound() {

        for (Car car : this.cars.getCarList()) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
        }

    }
}
