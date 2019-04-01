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
                System.out.println("입력된 자동차 이름이 올바르지 않습니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean inspectRuntimeNumber(String stringBasedNumber) {
        try {
            Integer.parseInt(stringBasedNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("입력 횟수가 올바르지 않습니다.");
            return false;
        }
    }

    private static boolean inspectCarNameLength(String carName) {
        return ((carName.length() <= VALID_NAME_LENGTH) && (carName.length() > 0)
                ? true : false);
    }
}
