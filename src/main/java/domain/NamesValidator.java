package domain;

import java.util.Arrays;
import java.util.List;

/**
 * 입력받은 이름의 유효성을 판단하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class NamesValidator {
    public static final String COMMA_DELIMITER = ",";
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int LIMIT_FOR_ARRAY_SIZE = -1;

    public static List<String> makeNames(String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(COMMA_DELIMITER, LIMIT_FOR_ARRAY_SIZE));
        for (String name : names) {
            checkSomethingIsHere(name);
            checkLengthIsFive(name);
        }
        return names;
    }

    private static void checkSomethingIsHere(String inputNames) {
        if (inputNames.isEmpty()) {
            throw new IllegalArgumentException("이름을 다시 입력해주세요.");
        }
    }

    private static void checkLengthIsFive(String inputNames) {
        if (inputNames.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 한다.");
        }
    }
}
