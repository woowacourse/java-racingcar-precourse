package racingcar;

import exception.InvalidInputException;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        Game game = new Game(scanner);
        try {
            game.start();
        } catch (InvalidInputException e) {
            System.out.println(e.getHEADER() + e.getMessage());
        }
    }
}
