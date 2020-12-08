package domain;

import java.util.Arrays;
import java.util.List;

/**
 * 입력받은 이름의 유효성을 판단하여 유효한 값을 돌려주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class NamesValidator {
    public static final String COMMA_DELIMITER = ",";
    public static final String ERROR_MESSAGE_WITH_NAME = "이름을 다시 입력해주세요.";
    public static final String ERROR_MESSAGE_WITH_LENGTH = "이름은 5자 이하여야 한다.";
    private static final int LIMIT_FOR_ARRAY_SIZE = -1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public static List<String> makeNames(final String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(COMMA_DELIMITER, LIMIT_FOR_ARRAY_SIZE));
        for (String name : names) {
            checkSomethingIsHere(name);
            checkLengthIsFive(name);
        }
        return names;
    }

    private static void checkSomethingIsHere(final String inputNames) {
        if (inputNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WITH_NAME);
        }
    }

    private static void checkLengthIsFive(final String inputNames) {
        if (inputNames.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WITH_LENGTH);
        }
    }
}
