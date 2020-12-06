package racingcar;

import java.util.List;
import java.util.Scanner;

import racingcar.controller.RaicingCarGame;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputView.setScanner(scanner);

        Cars cars = getCarNamesFromUser();
        RaicingCarGame raicingCarGame = new RaicingCarGame(cars);
        raicingCarGame.play();
    }

    private static Cars getCarNamesFromUser() {
        try{
            return Cars.of(InputView.getCarNames());
        }catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getCarNamesFromUser();
        }
    }
}
