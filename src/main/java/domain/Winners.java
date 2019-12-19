package domain;

import utils.OutputUtil;

import java.util.Collections;
import java.util.List;

public class Winners {
    private static final int EMPTY = 0;

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public Integer getWinnersSize() {
        return winners.size();
    }

    public boolean isNoWinner() {
        return winners.size() == EMPTY;
    }

    // TODO : 요놈도 UI 로직인가...?
    public void printWinner() {
        if (isNoWinner()) {
            OutputUtil.printNoneWinners();
            return;
        }
        OutputUtil.printWinners(this);
    }
}
