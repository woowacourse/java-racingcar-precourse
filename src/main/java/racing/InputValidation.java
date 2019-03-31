/**
 * class : InputValidation.java
 *
 * version : 1.0
 *
 * date : 2019.03.31
 *
 * author : icarus8050
 */

package racing;

/**
 * 사용자의 입력 값의 유효성을 검사하는 클래스
 */
public class InputValidation {
    private static final int VALID_NAME_LENGTH = 5;

    public static boolean inspectCarNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (!inspectCarNameLength(carName.trim())) {
                return false;
            }
        }
        return true;
    }

    private static boolean inspectCarNameLength(String carName) {
        return ((carName.length() <= VALID_NAME_LENGTH) && (carName.length() > 0)
                ? true : false);
    }
}
