package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private static final int INITIAL_LEADER_POSITION = -1;

    List<String> winners;

    public List<String> findWinners(List<Car> lineup) {
        winners = new ArrayList<>();
        int leaderPosition = INITIAL_LEADER_POSITION;
        for (Car participantCar : lineup) {
            int position = participantCar.getPosition();
            String name = participantCar.getName();
            leaderPosition = calculatePosition(leaderPosition, position, name);
        }
        return winners;
    }

    private int calculatePosition(int leaderPosition, int position, String name) {
        if (leaderPosition < position) {
            leaderPosition = position;
            winners.clear();
            winners.add(name);
        } else if (leaderPosition == position) {
            winners.add(name);
        }
        return leaderPosition;
    }
}
