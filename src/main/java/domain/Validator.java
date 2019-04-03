package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int MAXIMUM_LENGTH_OF_NAME = 5;

    public boolean hasInvalidLength(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
                System.out.println("이름의 길이는 " + MAXIMUM_LENGTH_OF_NAME + " 이하만 가능합니다.");
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicate(String[] carNames) {
        Set<String> nameSet = new HashSet(Arrays.asList(carNames));

        if (carNames.length != nameSet.size()) {
            System.out.println("중복된 이름은 포함할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean hasEmpty(String[] carNames) {
        if ((carNames.length == ZERO)
                || ((carNames.length == ONE) && (Arrays.asList(carNames).contains("")))) {
            System.out.println("아무것도 입력하지 않으셨습니다.");
            return true;
        }
        return false;
    }

    public boolean hasInvalid(String[] carNames) {
        return hasInvalidLength(carNames) || hasDuplicate(carNames) || hasEmpty(carNames);
    }
}