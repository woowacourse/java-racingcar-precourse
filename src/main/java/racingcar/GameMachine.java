package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameMachine {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void play() {
        Cars cars = createCars(
                inputView.readCarNames(),
                inputView.readCoins());
    }

    private Cars createCars(CarNames carNames, Coin coin) {
        return new Cars(
                IntStream.rangeClosed(1, carNames.amount())
                        .mapToObj(i -> new Car(carNames.next()))
                        .collect(Collectors.toList()),
                coin
        );
    }
}
