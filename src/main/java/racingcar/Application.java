package racingcar;

import racingcar.race.Race;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        new Race(scanner);
    }
}