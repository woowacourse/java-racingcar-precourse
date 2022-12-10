package racingcar.domain;

public class Round {
    private final int finalRound;
    private int tempRound = 1;

    public Round(int finalRound) {
        this.finalRound = finalRound;
    }

    public void next(){
        tempRound++;
    }
    public void clean(){
        tempRound = 1;
    }
    public boolean isReachedEnd(){
        if(tempRound == finalRound)return true;
        return false;
    }
}
