package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final int ZERO = 0;
    private final int MAXIMUM_LENGTH_OF_NAME = 5;

    public boolean hasInvalidLength(List<String> carNames) {
        for (String name: carNames) {
            if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
                System.out.println("이름의 길이는 " + MAXIMUM_LENGTH_OF_NAME + " 이하만 가능합니다.");
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicate(List<String> carNames) {
        Set<String> nameSet = new HashSet(carNames);

        if (carNames.size() != nameSet.size()) {
            System.out.println("중복된 이름은 포함할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean hasEmpty(List<String> carNames) {
        if (carNames.size() == ZERO) {
            System.out.println("아무것도 입력하지 않으셨습니다.");
            return true;
        }
        return false;
    }

    public boolean hasInvalid(List<String> carNames) {
        return hasInvalidLength(carNames) || hasDuplicate(carNames) || hasEmpty(carNames);
    }

    public boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                System.out.println("숫자만 입력할 수 있습니다.");
                return false;
            }
        }
        return true;
    }
}