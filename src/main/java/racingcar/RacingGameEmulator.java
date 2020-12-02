package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingGameEmulator {
    private final int TIMES;

    public static boolean gameOn;
    public static int winnerValue;
    public static ArrayList<String> winners;
    static HashMap<String, Integer> racingPlayResult;

    public RacingGameEmulator(int TIMES) {
        this.TIMES = TIMES;
        winners = new ArrayList<String>();
    }

    public void playGame() {
        while(RacingGamePlay.runTimes() != TIMES) {
            RacingGameSystemMessageOut.printEachMoves(RacingGamePlay.racingPlayBoard);
        }
        RacingGameSystemMessageOut.printEachMoves(RacingGamePlay.racingPlayBoard);
    }

    public void getResults() {
        racingPlayResult = RacingGamePlay.racingPlayBoard;
        winnerValue = RacingGamePlay.maxRace;
    }

    public void updateWinners(HashMap<String, Integer> racingPlayResult) {
        for(String carName : racingPlayResult.keySet()) {
            if (racingPlayResult.get(carName) == winnerValue) {
                winners.add(carName);
            }
        }
    }
}
