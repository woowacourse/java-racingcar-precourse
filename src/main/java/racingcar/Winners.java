package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners = new ArrayList<>();

    public Winners() {
    }

    public int getWinnersCnt() {
        if (winners == null) {
            return 0;
        }
        return winners.size();
    }

    public void addWinner(String winner) {
        winners.add(winner);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int len = getWinnersCnt();

        sb.append(winners.get(0));
        for (int i = 1; i < len; i++) {
            sb.append(", ").append(winners.get(i));
        }
        return sb.toString();
    }
}
