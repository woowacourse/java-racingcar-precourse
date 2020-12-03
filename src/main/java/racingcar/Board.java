package racingcar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Board {
    private final String MESSAGE_GAME_RESULT = "\n실행 결과";
    private final String SYMBOL_CAR_MOVEMENT = "-";
    private final String SEPARATOR_NAME_PROGRESS = " : ";

    public void printAccumulatedRoundsResult() {
        System.out.println(MESSAGE_GAME_RESULT);
        for (int roundNumber = 0; roundNumber < GameManager.numberTryToMove; roundNumber++) {
            HashMap round = Round.roundsInformation.get(roundNumber);
            printRoundResult(round);
        }
    }

    private void printRoundResult(HashMap round) {
        Set roundSet = round.entrySet();
        Iterator roundIterator = roundSet.iterator();
        while (roundIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)roundIterator.next();
            System.out.printf(entry.getKey().toString()+SEPARATOR_NAME_PROGRESS);
            printCarProgressPerRound(entry);
        }
        System.out.println("");
    }

    private void printCarProgressPerRound(Entry entry) {
        int currentCarPosition = (int)entry.getValue();
        for (int i = 0; i < currentCarPosition; i++) {
            System.out.printf(SYMBOL_CAR_MOVEMENT);
        }
        System.out.println("");
    }
}
