package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int FIRST_ROUND = 1;

    private List<Car> players = new ArrayList<>();

    Player(List<String> carNames) {
        for (String carName : carNames)
            players.add(new Car(carName));
    }

    public void play(GameRound gameRound) {
        int thisRound = FIRST_ROUND;
        while (!gameRound.isGameOver(thisRound)) {
            moveOrStop();
            OutputView.printResultOfEachRound(players);
            thisRound++;
        }
        Winner winner = new Winner(players);
        OutputView.printWinner(winner);
    }

    private void moveOrStop() {
        for (Car car : players) {
            car.moveOrStop();
        }
    }
}
