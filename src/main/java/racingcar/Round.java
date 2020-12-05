package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

interface playableRound {

    static ArrayList<HashMap<String, Integer>> getRoundsInformation() {
        return null;
    }
    void registerCarMovement(int roundNumber, String name, int position);
    void start(HashMap<String, Car> carNameAndCarObjects, Round round, int roundNumber);
}

public class Round implements playableRound {
    private static ArrayList<HashMap<String, Integer>> roundsInformation = new ArrayList<>();

    public Round() {
        roundsInformation.add(new HashMap<>());
    }

    public void registerCarMovement(int roundNumber, String name, int position) {
        HashMap<String, Integer> roundInformation = roundsInformation.get(roundNumber);
        roundInformation.put(name, position);
    }

    public void start(HashMap<String, Car> carNameAndCarObjects, Round round, int roundNumber) {
        for (String carName : carNameAndCarObjects.keySet()) {
            carNameAndCarObjects.get(carName).tryToMove(round, roundNumber);
        }
    }

    public static ArrayList<HashMap<String, Integer>> getRoundsInformation() {
        return roundsInformation;
    }
}