package racingcar;

import java.util.ArrayList;
import java.util.List;

import view.OutputView;

public class Player {
    private static final int FIRST_ROUND = 1;

    private List<Car> players = new ArrayList<>();

    public Player(List<String> carNames) {
        for (String carName : carNames)
            players.add(new Car(carName));
    }

    public void play(GameRound gameRound) {
        OutputView.printPlayingScreen();
        run(gameRound);
        findWinner();
    }

    private void run(GameRound gameRound) {
        int thisRound = FIRST_ROUND;
        while (!gameRound.isGameOver(thisRound)) {
            moveOrStopAndPrintResult();
            thisRound++;
        }
    }

    private void moveOrStopAndPrintResult() {
        moveOrStop();
        OutputView.printResultOfEachRound(players);
    }

    private void moveOrStop() {
        for (Car car : players) {
            car.moveOrStop();
        }
    }

    private void findWinner() {
        OutputView.printWinner(new Winner(players));
    }
}
