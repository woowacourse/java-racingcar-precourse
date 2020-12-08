package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputView inputView = new InputView(scanner);
        RacingGameController racingGameController = new RacingGameController(inputView);
        racingGameController.run();
        scanner.close();
    }
}
