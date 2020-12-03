package racingcar;

public class Round {
    public int round;

    public Round(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void decreaseRound(int round) {
        round--;
    }
}
