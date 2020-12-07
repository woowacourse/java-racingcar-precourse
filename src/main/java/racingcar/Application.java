package racingcar;

import racingcar.controller.RaceController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RaceController raceController = new RaceController(scanner);
        raceController.run();
    }
}
