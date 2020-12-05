package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AwardGiver implements Awardable {

    private ArrayList<String> awardReceiverList = new ArrayList<>();
    private int distanceForWinner;

    public void printAwardReceiver(HashMap<String, Car> participants,
            ArrayList<HashMap<String, Integer>> allRoundsResults, int numberTotalRounds) {

        distanceForWinner = findWinnerCondition(allRoundsResults, numberTotalRounds);

        findWinnerInParticipants(participants);

        System.out.printf(MESSAGE_WINNER);
        System.out.println(String.join(DELIMITER, awardReceiverList));
    }

    private int findWinnerCondition(ArrayList<HashMap<String, Integer>> allRoundsResults,
            int numberTotalRounds) {

        int lastRoundNumber = numberTotalRounds - 1;
        HashMap lastRoundInformation = allRoundsResults.get(lastRoundNumber);

        return (int)Collections.max(lastRoundInformation.values());
    }


    private void findWinnerInParticipants(HashMap<String, Car> participants) {
        Set carsSet = participants.entrySet();
        Iterator carsIterator = carsSet.iterator();

        while (carsIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)carsIterator.next();
            compareCarWithWinnerCondition(entry, distanceForWinner);
        }
    }

    private void compareCarWithWinnerCondition(Entry entry, int distanceForWinner) {
        Car car = (Car)entry.getValue();

        if (car.isWinner(distanceForWinner)) {
            awardReceiverList.add((String)entry.getKey());
        }
    }
}
