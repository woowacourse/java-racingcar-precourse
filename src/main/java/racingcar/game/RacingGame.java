package racingcar.game;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.UserInputUtil.*;

public class RacingGame {

    private void progressGame(List<Car> carList) {
        for (Car car : carList) {
            car.progress();
            car.printProgress();
        }

        System.out.println();
    }

    private List<Car> getCarList() {
        String[] carNames = getCarNames();

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
