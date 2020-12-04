package racingcar;

import utils.InputValidator;

public class Rounds {
    public static final int MIN_TOTAL_ROUND = 0;
    public static final int MAX_TOTAL_ROUND = Integer.MAX_VALUE;

    private final int totalRound;
    private int thisRound;

    private Rounds(int totalRound){
        InputValidator.checkValidRounds(totalRound);
        this.thisRound = 0;
        this.totalRound = totalRound;
    }

    public static Rounds initialize(int totalRound){
        return new Rounds(totalRound);
    }

    public void next(){
        thisRound++;
    }

    public boolean isEnd(){
        return thisRound >= totalRound;
    }
}
