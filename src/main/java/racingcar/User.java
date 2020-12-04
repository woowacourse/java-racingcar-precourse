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
    private int racingCount = 0;

    public User() {
        this.names = new Names();
    }

    public List<String> createNames(String input) {
        return names.validate(input);
    }

    public int createCount(String input) {
        try {
            racingCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 허용하는 숫자가 아닙니다.");
        }
        return racingCount;
    }

    public String createWinners(final List<String> winners) {
        return WINNER + String.join(DELIMITER + SPACE, winners);
    }
}
