package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    List<String> winners;

    public List<String> findWinners(List<Car> lineup) {
        winners = new ArrayList<>();
        int leaderPosition = -1;
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
