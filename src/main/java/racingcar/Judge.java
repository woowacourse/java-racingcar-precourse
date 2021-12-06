package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private List<String> winners;
    private Integer leaderPosition = -1;

    public List<String> findWinners(List<Car> lineup) {
        winners = new ArrayList<>();
        for (Car participantCar : lineup) {
            int position = participantCar.getPosition();
            String name = participantCar.getName();
            leaderPosition = calculatePosition(position, name);
        }
        return winners;
    }

    private int calculatePosition(int position, String name) {
        if (isBiggerThanPresentLeaderPosition(position)) {
            makeNewWinner(position, name);
            return leaderPosition;
        }
        if (isEqualToPresentLeaderPosition(position)) {
            makeJointWinner(name);
        }
        return leaderPosition;
    }

    private boolean isBiggerThanPresentLeaderPosition(int position) {
        return leaderPosition < position;
    }

    private void makeNewWinner(int position, String name) {
        leaderPosition = position;
        winners.clear();
        winners.add(name);
    }

    private boolean isEqualToPresentLeaderPosition(int position) {
        return leaderPosition == position;
    }

    private void makeJointWinner(String name) {
        winners.add(name);
    }
}
