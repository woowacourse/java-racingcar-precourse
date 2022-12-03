package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameMachine {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private static final int LIMIT = 1_000_000;
    private int tolerance = 0;

    public void play() {
        Cars cars = createCars(
                readCarNames(),
                readCoins());
        cars.move();
        outputView.printWinners(cars.findWinners());
    }

    private Cars createCars(CarNames carNames, Coin coin) {
        return new Cars(
                IntStream.rangeClosed(1, carNames.amount())
                        .mapToObj(i -> new Car(
                                carNames.next(),
                                new RandomNumberGenerator()
                        ))
                        .collect(Collectors.toList()),
                coin
        );
    }

    // todo: read 부분 추상화하기
    private CarNames readCarNames() {
        try {
            return inputView.readCarNames();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            plusGameTimes();
            return inputView.readCarNames();
        }
    }

    private Coin readCoins() {
        try {
            return inputView.readCoins();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            plusGameTimes();
            return inputView.readCoins();
        }
    }

    private void plusGameTimes() {
        tolerance += 1;
        if (tolerance > LIMIT) {
            throw new IllegalArgumentException("[ERROR] 게임 진행 횟수 한도가 초과되었습니다. 악성 접근으로 판단되어 게임이 종료됩니다.");
        }
    }
}
