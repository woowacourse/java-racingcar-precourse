package racingcar;

import exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        Game game = new Game(scanner);
        try {
            game.start();
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
        } catch (InvalidInputException e) {
            System.out.println(e.getHEADER() + e.getMessage());
        }
    }
}
