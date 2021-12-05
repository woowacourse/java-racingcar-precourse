package racingcar;

import static racingcar.StringConstants.DELIMITER_BETWEEN_WINNERS;
import static racingcar.StringConstants.PREFIX_OF_WINNER_NOTICE;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinnersView {
    private final List<Car> winners;
    private final StringBuilder winnerNotice = new StringBuilder();

    public RacingWinnersView(List<Car> winners) {
        this.winners = winners;
    }

    public void print() {
        writeWinnerNotice();
        System.out.println(winnerNotice);
    }

    private void writeWinnerNotice() {
        winnerNotice.append(PREFIX_OF_WINNER_NOTICE);
        winnerNotice.append(writeWinnerNames(winners));
    }

    private String writeWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_BETWEEN_WINNERS));
    }
}
