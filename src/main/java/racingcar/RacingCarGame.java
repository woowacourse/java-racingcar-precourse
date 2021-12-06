package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RepetitionNumber;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {
    private Cars cars;
    private RepetitionNumber repetitionNumber;
    private Input input;

    public RacingCarGame(Input input) {
        this.input = input;
    }

    public void run() {
        initialize();
        round();
        Output.printAllRoundResult();
        Output.printWinners(cars.findWinnerCars());
    }

    private void round() {
        int roundCount = 0;
        while (!repetitionNumber.isSameNumber(roundCount++)) {
            cars.play();
        }
    }

    private void initialize() {
        cars = input.inputCarNames();
        repetitionNumber = input.inputRepetitionNumber();
    }
}
