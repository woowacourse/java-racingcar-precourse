package racingcar;

import java.util.List;

public interface RacingGame {
    public void addCar(Car car);
    public void printWinner();
    public void startRacingGame(int carMoveAttemptCount);
}
