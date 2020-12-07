package racingcar;

import racingcar.controller.RacingManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RacingManager racingManager = new RacingManager();
        racingManager.startRace(scanner);
    }
}
