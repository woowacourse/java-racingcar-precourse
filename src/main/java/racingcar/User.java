package racingcar;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class User {
    public static final String DELIMITER = ",";
    private static final String WINNER = "최종우승자: ";
    private static final String SPACE = " ";
    private Names names;
    private Count racingCount;

    public User() {
        this.names = new Names();
        this.racingCount = new Count();
    }

    public List<String> createNames(String input) {
        return names.validate(input);
    }

    public int createCount(String input) {
        return racingCount.validate(input);
    }

    public String createWinners(final List<String> winners) {
        return WINNER + String.join(DELIMITER + SPACE, winners);
    }
}
