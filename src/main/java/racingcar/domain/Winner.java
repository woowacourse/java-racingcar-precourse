package racingcar.domain;

import java.util.Iterator;
import java.util.List;

public class Winner {
    private static final String COMMA_SPACE = ", ";

    private List<Car> winners;

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinners() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getName());
            if(i != winners.size() - 1) {
                stringBuilder.append(COMMA_SPACE);
            }
        }
        return stringBuilder.toString();
    }
}
