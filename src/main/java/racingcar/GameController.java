package racingcar;

import view.InputView;
import domain.Car;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private Car[] cars;

    GameController() {
        inputView = new InputView();
    }

    private void initCars(List<String> names) {
        int len = names.size();
        cars = new Car[len];

        for(int i = 0; i < len; i++) {
            cars[i] = new Car(names.get(i));
        }
    }

    public void start() {
        List<String> names = inputView.getNames();
        initCars(names);
    }
}
