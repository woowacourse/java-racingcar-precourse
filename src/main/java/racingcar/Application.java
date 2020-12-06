package racingcar;

import controller.RacingController;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RacingController racingController = new RacingController(scanner);
        racingController.playGame();
    }
}
