package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    private static ArrayList<HashMap<String, Integer>> roundsInformation = new ArrayList<>();

    public Round() {
        roundsInformation.add(new HashMap<>());
    }

    public void registerCarMovement(int roundNumber, String name, int position) {
        HashMap<String, Integer> roundInformation = roundsInformation.get(roundNumber);
        roundInformation.put(name, position);
    }

    public void start(HashMap<String, Car> participants, Round round, int roundNumber) {
        for (String participant : participants.keySet()) {
            participants.get(participant).tryToMove(round, roundNumber);
        }
    }

    public static ArrayList<HashMap<String, Integer>> getRoundsInformation() {
        return roundsInformation;
    }
}