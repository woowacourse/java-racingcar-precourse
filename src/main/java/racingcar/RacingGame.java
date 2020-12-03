package racingcar;

import utils.GameUtils;

import java.util.List;
import java.util.Scanner;

public class RacingGame {
    Scanner scanner;
    List<Car> racingCars;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
    }

    public void registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.next().split(",");
        for (int i = 0; i < carNames.length; i++) {
            GameUtils.isCarNameRight(carNames[i]);
            racingCars.add(new Car(carNames[i]));
        }
    }

    public void getNumberOfRunsFromUser() {
    }

    public void findWinner() {
    }

    public void printWinner() {
    }

    public void printCars() {
    }
}
