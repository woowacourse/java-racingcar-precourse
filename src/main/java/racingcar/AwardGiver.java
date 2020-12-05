package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

interface Awardable {
    String MESSAGE_WINNER = "최종 우승자: ";
    String DELIMITER = ", ";

    void printAwardReceiver(HashMap<String, Car> carNameAndCarObjects,
        ArrayList<HashMap<String, Integer>> allRoundResults, int numberTotalRounds);
}

public class AwardGiver implements Awardable {

    private ArrayList<String> listAwardReceiver = new ArrayList<>();
    private int distanceForWinner;

    public void printAwardReceiver(HashMap<String, Car> carNameAndCarObjects,
            ArrayList<HashMap<String, Integer>> allRoundsResults, int numberTotalRounds) {

        distanceForWinner = findConditionToWin(allRoundsResults, numberTotalRounds);

        findWinner(carNameAndCarObjects);

        System.out.printf(MESSAGE_WINNER);
        System.out.println(String.join(DELIMITER, listAwardReceiver));
    }

    private int findConditionToWin(ArrayList<HashMap<String, Integer>> allRoundsResults,
            int numberTotalRounds) {

        int lastRoundNumber = numberTotalRounds - 1;
        HashMap lastRoundInformation = allRoundsResults.get(lastRoundNumber);

        return (int)Collections.max(lastRoundInformation.values());
    }


    private void findWinner(HashMap<String, Car> carNameAndCarObjects) {
        Set carsSet = carNameAndCarObjects.entrySet();
        Iterator carsIterator = carsSet.iterator();

        while (carsIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)carsIterator.next();
            compareCarWithWinnerCondition(entry, distanceForWinner);
        }
    }

    private void compareCarWithWinnerCondition(Entry entry, int distanceForWinner) {
        Car car = (Car)entry.getValue();

        if (car.isWinner(distanceForWinner)) {
            listAwardReceiver.add((String)entry.getKey());
        }
    }
}
