package racingcar;


import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    public static ArrayList<HashMap<String, Integer>> roundsInformation =
        new ArrayList<>(GameManager.numberTryToMove);

    public Round() {
        roundsInformation.add(new HashMap<>());
    }

    public static void registerCarMovement(int roundNumber, String name, int position) {
        HashMap<String, Integer> roundInformation = roundsInformation.get(roundNumber);
        roundInformation.put(name, position);
    }

    public void start(HashMap<String, Car> participants, int roundNumber) {
        for (String participant : participants.keySet()) {
            participants.get(participant).tryToMove(roundNumber);
        }
    }
}