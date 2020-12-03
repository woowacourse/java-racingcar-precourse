package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Rule;
import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RacingCarGame racingCarGame = new RacingCarGame(scanner);
        racingCarGame.play();
    }
}
