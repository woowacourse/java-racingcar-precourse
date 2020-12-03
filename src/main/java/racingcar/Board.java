package racingcar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Board {
    private static final String MESSAGE_GAME_RESULT = "\n실행 결과";
    private static final String SYMBOL_CAR_MOVEMENT = "-";


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
            System.out.printf(entry.getKey().toString()+" : ");
            printCarProgressPerRound(entry);
        }
        System.out.println("");
    }

    private void printCarProgressPerRound(Entry entry) {
        for (int i = 0; i < (int)entry.getValue(); i++) {
            System.out.printf(SYMBOL_CAR_MOVEMENT);
        }
        System.out.println("");
    }
}
