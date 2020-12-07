package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.View;

import java.util.Scanner;

public class RaceController {
    private Cars cars;
    private View view;
    private int times;

    public RaceController(Scanner scanner) {
        view = new View(scanner);
    }

    public void run() {
        inputCarName();
        inputTimes();
        startRace();
    }

    private void inputCarName() {
        cars = new Cars(view.askCarName());
    }

    private void inputTimes() {
        times = view.askTime();
    }

    private void startRace() {
        view.showResultMessage();

        while (--times >= 0) {
            cars.move();

        }

    }
}
