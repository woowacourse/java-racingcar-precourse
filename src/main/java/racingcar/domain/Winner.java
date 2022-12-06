package racingcar.domain;

import java.util.List;

public class Winner {

    private final List<String> winner;

    public Winner(List<String> winner) {
        this.winner = winner;
    }

    public List<String> getWinner() {
        return winner;
    }
}
