package racingcar;
/*
 * Application
 *
 * version 1.0
 *
 * 2020.12.05
 *
 * Copyright (c) by Davinci.J
 */
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
                System.out.println(race.decideWinner());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
