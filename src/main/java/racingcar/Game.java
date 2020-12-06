package racingcar;

import racingcar.view.InputView;
import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;
    private Scoreboard scoreboard;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        setScoreboard();
        int attemptCount = this.inputView.scanAttemptCount();
        for (int round = 0; round < attemptCount; round++) {
            scoreboard.runRound();
        }
    }

    private void setScoreboard() {
        Scoreboard scoreboard = new Scoreboard(makeCars());
        this.scoreboard = scoreboard;
    }

    private List<Car> makeCars() {
        List<String> carNameList = this.inputView.scanCarName();
        List<Car> carList = new ArrayList<Car>();
        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
        }
        return carList;
    }
}
