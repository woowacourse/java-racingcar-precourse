package Race;

import View.OutputView;
import racingcar.Car;
import racingcar.Cars;

import java.util.List;

public class Referee {
    private OutputView winnerBoard = new OutputView();

    public Referee() {

    }

    private boolean isWinner(Car car, int winnerScore) {
        return car.getScore() == winnerScore;
    }
}
