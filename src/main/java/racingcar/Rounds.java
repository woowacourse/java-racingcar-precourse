package racingcar;

public class Rounds {
    private final int totalRound;
    private int thisRound;

    private Rounds(int totalRound){
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
