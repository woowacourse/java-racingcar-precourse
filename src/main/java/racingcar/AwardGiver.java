package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AwardGiver {
    private final String MESSAGE_WINNER = "최종 우승자: ";
    private final String DELIMITER = ", ";
    private ArrayList<String> awardReceiverList = new ArrayList<>();

    public void printAwardReceiver(HashMap<String, Car> participants,
        ArrayList<HashMap<String, Integer>> allRoundsResults, int numberTryToMove) {
        int lastRoundNumber = numberTryToMove - 1;
        HashMap lastRoundInformation = allRoundsResults.get(lastRoundNumber);
        int longestDistance = (int)Collections.max(lastRoundInformation.values());

        findWinnerInParticipants(participants, longestDistance);

        System.out.printf(MESSAGE_WINNER);
        System.out.println(String.join(DELIMITER, awardReceiverList));
    }

    private void findWinnerInParticipants(HashMap<String, Car> participants, int longestDistance) {
        Set carsSet = participants.entrySet();
        Iterator carsIterator = carsSet.iterator();

        while (carsIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)carsIterator.next();
            compareCarWithWinnerCondition(entry, longestDistance);
        }
    }

    private void compareCarWithWinnerCondition(Entry entry, int longestDistance) {
        Car car = (Car)entry.getValue();

        if (car.isWinner(longestDistance)) {
            awardReceiverList.add((String)entry.getKey());
        }
    }
}
