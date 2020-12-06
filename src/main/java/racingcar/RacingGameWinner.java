package racingcar;

import java.util.ArrayList;

public class RacingGameWinner {

    private final ArrayList<Car> racingGameResults;
    private final int WINNING_VALUE;

    private ArrayList<String> racingGameWinners;

    public RacingGameWinner(ArrayList<Car> racingGameResults, int WINNING_VALUE) {
        this.racingGameResults = racingGameResults;
        this.WINNING_VALUE = WINNING_VALUE;
        this.racingGameWinners = new ArrayList<String>();
    }

    public void findWinner() {
        for (Car car : racingGameResults) {
            if (car.getCarPosition() == WINNING_VALUE) {
                racingGameWinners.add(car.getCarName());
            }
        }
    }

    public void printWinner() {
        RacingGameSystemMessageOut.printFinalWinners(racingGameWinners);
    }
}
