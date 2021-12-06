package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";

    public void validateCarNameListInput(String[] nameList) {
        for (String name: nameList) {
            validateLength(name);
        }
        validateExistDuplicateName(nameList);
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + "자동차의 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하여야 한다.");
        }
    }

    private void validateExistDuplicateName(String[] nameList) {
        Set<String> set = new HashSet<>(Arrays.asList(nameList));
        if (set.size() != nameList.length) throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + "중복된 자동차의 이름을 입력할 수 없다.");
    }
}