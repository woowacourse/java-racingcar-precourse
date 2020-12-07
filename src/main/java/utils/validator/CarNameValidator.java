package utils.validator;

/**
 * 이 클래스는 자동차 이름 입력을 검증하는 클래스입니다.
 * - 자동차 이름의 길이를 검증합니다.
 * - 자동차 이름이 비어있거나 공백인지 검증합니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class CarNameValidator {

    private static final String NAME_LENGTH_ERROR_MSG = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String NAME_EMPTY_ERROR_MSG = "[ERROR] 자동차 이름으로 빈 칸은 안됩니다.";

    private CarNameValidator() {}

    public static void validateCarName(String carName) {
        validateNameLength(carName);
        validateNameEmpty(carName);
    }

    private static void validateNameLength(String carName) {
        int carNameLength = carName.length();
        if (carNameLength > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MSG);
        }
    }

    private static void validateNameEmpty(String carName) {
        if (carName.equals(" ") || carName.equals("")) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR_MSG);
        }
    }
}
