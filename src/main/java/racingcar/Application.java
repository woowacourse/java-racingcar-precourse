package racingcar;
/*
 * Application
 *
 * version 1.0
 *
 * 2020.12.06
 *
 * Copyright (c) by Davinci.J
 */
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputManager inputManager = new InputManager(scanner);
        Race race = Race.generateRace(inputManager);
        while (true) {
            try {
                race.startCarRace(inputManager.inputCountOfAttempts());
                System.out.println(race.decideWinner());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
