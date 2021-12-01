package racingcar;

import java.util.List;

public class CarNameValidator {
    static final int NAME_SIZE = 5;
    static final String NAME_SIZE_ERROR_MESSAGE = "[ERROR] 이름은 1자 이상 5자 이하여야 한다.";

    public static void checkException(List<String> carNameList) {
        if (!checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }
    }

    public static boolean checkCarNameLength(List<String> carNameList) {
        return carNameList.stream()
                .filter(carName -> carName.length() > 0 && carName.length() <= NAME_SIZE)
                .count() == carNameList.size();
    }
}
