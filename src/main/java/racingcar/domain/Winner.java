package racingcar.domain;

import java.util.List;

public class Winner {
    private List<Car> winners;

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinners() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) {
                stringBuilder.append(winners.get(i).getName());
                break;
            }
            stringBuilder.append(winners.get(i).getName() + ", ");
        }
        return stringBuilder.toString();
    }
}
