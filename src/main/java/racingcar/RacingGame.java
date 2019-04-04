package racingcar;

import racingcar.utils.CarListGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public void run(){
        RacingCars racingCars = new RacingCars(CarListGenerator.generate(InputView.inputCarNames()));

        printResult(racingCars);

        ResultView.printWinner(racingCars.getWinners());
    }

    private void printResult(RacingCars racingCars) {

        int moveCount = InputView.inputGameCount();

        System.out.println("실행 결과");
        while (moveCount-- > 0) {
            CarDriving.move(racingCars);

            ResultView.printResult(racingCars);
        }

    }
}
