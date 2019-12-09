/*
 *  @RacingGame.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.09
 *
 *  @Author: pandahun
 */

package domain;

import io.InputView;
import io.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public static final int ZERO = 0;

    private final RacingCars racingCars;
    private final int tryCount;


    private RacingGame(RacingCars racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public static RacingGame init() {
        RacingCars racingCars = assembleCars();
        int tryCount = InputView.inputTryCount();
        return new RacingGame(racingCars, tryCount);
    }

    private static RacingCars assembleCars() {
        List<String> names = InputView.inputNames();
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public void run() {
        for(int i=0; i<tryCount; i++){
            racingCars.move(new RandomValue());
            OutputView.showNow(racingCars);
        }
        OutputView.showWinners(racingCars.getWinners());
    }

}
