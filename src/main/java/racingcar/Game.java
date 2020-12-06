package racingcar;

import racingcar.view.InputView;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        makeCars();
    }

    private List<Car> makeCars() {
        List<String> carNameList = this.inputView.scanCarName();
        List<Car> carList = new ArrayList<Car>();
        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
        }
        return carList;
    }
}
