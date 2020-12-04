package racingcar.domain;

import java.util.List;

public class Winners {
    private static final String COMMA_SPACE = ", ";

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerNames() {
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
