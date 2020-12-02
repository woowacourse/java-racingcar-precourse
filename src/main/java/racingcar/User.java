package racingcar;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class User {
    public static final String DELIMITER = ",";

    public List<String> createNames(String names) {
        return Arrays.asList(names.split(DELIMITER));
    }

    public int createGameCount(String nextLine) {
        return Integer.parseInt(nextLine);
    }
}
