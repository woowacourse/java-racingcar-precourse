package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Player {
    private static final String DELIM = ",";
    private static final int FIRST_ROUND = 1;

    private List<Car> players = new ArrayList<>();

    Player(String carNames) {
        StringTokenizer carNameTokens = new StringTokenizer(carNames, DELIM);
        while (carNameTokens.hasMoreTokens()) {
            players.add(new Car(carNameTokens.nextToken()));
        }
    }

    public void play(GameRound gameRound) {
        int thisRound = FIRST_ROUND;
        while (!gameRound.isGameOver(thisRound)) {
            moveOrStop();
            OutputView.printResultOfEachRound(players);
            thisRound++;
        }
        Winner winner = new Winner(players);
    }

    private void moveOrStop() {
        for (Car car : players) {
            car.moveOrStop();
        }
    }
}
