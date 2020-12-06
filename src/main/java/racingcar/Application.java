package racingcar;

import racingcar.race.RaceController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RaceController race = new RaceController();

        race.generateCars(scanner);
        race.setRaceRound(scanner);
        race.start();
        race.showWinner();
    }
}