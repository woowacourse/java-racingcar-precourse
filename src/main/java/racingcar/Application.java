package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputManager inputManager = new InputManager(scanner);
        Race race = Race.generateRace(inputManager);
        while (true) {
            try {
                race.startCarRace(inputManager.inputTrialCount());
                race.decideWinner();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
