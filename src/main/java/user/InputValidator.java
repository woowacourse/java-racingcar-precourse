package user;

/**
 * @author 김시영
 * @apiNote 사용자 입력값 에러를 검증하기 위한 클래스로 문자열 길이 확인, 공백제거의 메서드로 이루어져있습니다.
 * @since 2019-12-05
 */
public class InputValidator {
    private static final int ZERO = 0;
    private static final int CAR_NAME_MAX_SIZE = 5;

    private int correctInputCount = ZERO;

    public static boolean checkItIsZero(int howManyPlay) {
        if (howManyPlay == ZERO) {
            return true;
        }
        return false;
    }

    /**
     * 자동차 이름이 적합한지 검증하는 기능으로 인자로 인자의 각 인덱스에 해당하는 값들이 모두 검증되어, 배열 크기와 같은 경우 True 리턴
     * @param userInput String 배열
     * @return
     */
    public boolean checkCarNames(String[] userInput) {
        correctInputCount = ZERO;
        String[] input = deleteFrontBackBlank(userInput);
        for (int i = 0; i < input.length; i++) {
            checkCarNameSize(input[i]);
        }
        return carNameIsOkOrNot(correctInputCount, input.length);
    }

    private boolean carNameIsOkOrNot(int correctInputCount, int inputCount) {
        return correctInputCount == inputCount;
    }

    private String[] deleteFrontBackBlank(String[] userInput) {
        for (int i = 0; i < userInput.length; i++) {
            userInput[i] = userInput[i].trim();
        }
        return userInput;
    }

    private void checkCarNameSize(String input) {
        int length = input.length();
        if (length <= CAR_NAME_MAX_SIZE && length > ZERO)
            correctInputCount++;
    }
}
