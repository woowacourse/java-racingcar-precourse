package racingcar;

import static game.Message.WINNER_DELIMITER;
import static game.Message.WINNER_MESSAGE;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/06
 */
public class Winner {
    private String winners;

    public Winner(Cars cars) {
        this.winners = winnersToString(cars.findWinners());
    }

    private String winnersToString(final List<String> winners) {
        return String.join(WINNER_DELIMITER, winners);
    }

    @Override
    public String toString() {
        return WINNER_MESSAGE + winners;
    }
}
