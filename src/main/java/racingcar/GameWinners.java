package racingcar;

import java.util.ArrayList;

public class GameWinners {
    final private ArrayList<String> winners = new ArrayList<String>();
    private int victoryScore = 0;

    public ArrayList<String> getGameWinners() {
        return winners;
    }

    public GameWinners(ArrayList<Car> participatedCars, int repetitionTime) {
        findVictoryScore(participatedCars);
        findWinner(participatedCars);
    }

    private void findWinner(ArrayList<Car> participatedCars) {
        for (Car player : participatedCars) {
            checkWinner(player);
        }
    }

    private void checkWinner(Car player) {
        if (player.getPosition() == victoryScore) {
            winners.add((player.getName()));
        }
    }

    private void findVictoryScore(ArrayList<Car> participatedCars) {
        for (Car player : participatedCars) {
            checkVictoryScore(player.getPosition());
        }
    }

    private void checkVictoryScore(int playerScore) {
        if (playerScore > victoryScore) {
            victoryScore = playerScore;
        }
    }
}
