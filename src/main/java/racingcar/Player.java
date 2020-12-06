package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Player {
    private List<Car> players = new ArrayList<>();

    Player(String carNames) {
        StringTokenizer carNameTokens = new StringTokenizer(carNames, ",");
        while (carNameTokens.hasMoreTokens()) {
            players.add(new Car(carNameTokens.nextToken()));
        }
    }

    public void play(GameRound gameRound) {
        int thisRound = 1;
        while (!gameRound.isGameOver(thisRound)) {
            moveOrStop();
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
