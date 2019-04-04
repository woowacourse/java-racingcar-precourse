package racingcar;

import racingcar.utils.CarListGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public void run(){
        RacingCars racingCars = new RacingCars(CarListGenerator.generate(InputView.inputCarNames()));

        printResult(racingCars);
    }

    private void printResult(RacingCars racingCars) {
        System.out.println("실행 결과");

        int moveCount = InputView.inputGameCount();

        while (moveCount-- > 0) {
            CarDriving.move(racingCars);

            ResultView.printResult(racingCars);
        }

    }
}
