package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public interface Awardable {
    String MESSAGE_WINNER = "최종 우승자: ";
    String DELIMITER = ", ";

    void printAwardReceiver(HashMap<String, Car> participants,
            ArrayList<HashMap<String, Integer>> allRoundResults, int numberTotalRounds);
}
