package racingcar;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class User {
    public static final String DELIMITER = ",";
    private static final String WINNER = "최종우승자: ";
    private static final String SPACE = " ";
    private static final CharSequence TAB = "\t";
    private static final int NAME_LENGTH = 5;

    public List<String> createNames(String names) {
        String[] splitNames = names.split(DELIMITER);
        validateName(names);
        validateNameLength(splitNames);
        return Arrays.asList(splitNames);
    }

    private void validateName(String names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름이 존재하지 않습니다.");
        }
        if (names.contains(SPACE) || names.contains(TAB)) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 존재합니다.");
        }
    }

    private void validateNameLength(String[] splitNames) {
        for (String name : splitNames) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 이름이 5자가 넘습니다.");
            }
        }
    }

    public int createCount(String nextLine) {
        return Integer.parseInt(nextLine);
    }

    public String createWinners(final List<String> winners) {
        return WINNER + String.join(DELIMITER + SPACE, winners);
    }
}
