package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final int attempt;

    public RacingGame() {
        cars = createCars(InputView.inputCarList());
        attempt = InputView.inputAttempt();
    }

    public void play() {
        startRacing(attempt);
        finish();
    }

    private Cars createCars(String[] carNameList) {
        List<Car> cars = Arrays.stream(carNameList)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private void startRacing(int attempt) {
        OutputView.printResultMessage();
        for (int i = 0; i < attempt; i++) {
            cars.race();
        }
    }

    private void finish() {
        List<String> winnerList = cars.getWinnerList();
        OutputView.printWinnerList(winnerList);
    }
}
