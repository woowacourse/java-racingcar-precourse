package racingcar;

import racingcar.controller.RacingGrameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new RacingGrameController(scanner).playRacingCarGame();
    }
}
