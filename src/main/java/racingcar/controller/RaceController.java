package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.View;

import java.util.Scanner;

public class RaceController {
    private Cars cars;
    private View view;

    public RaceController(Scanner scanner) {
        view = new View(scanner);
    }

    public void run() {
        inputCarName();
    }

    private void inputCarName() {
        cars = new Cars(view.askCarName());
    }
}
