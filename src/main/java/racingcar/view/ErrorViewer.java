package racingcar.view;

public class ErrorViewer {
    private static final String LENGTH_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름의 길이는 5를 넘어선 안된다.";
    private static final String CARS_INPUT_ERROR_MESSAGE = "[ERROR] 중복된 차 이름이 있으면 안된다.";
    private static final String NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String VOID_INPUT_ERROR_MESSAGE = "[ERROR] 빈 값을 입력해선 안된다.";

    /* 차의 이름 길이가 길 경우를 표시하는 에러 메세지 */
    public static void showLengthInputError() {
        throw new IllegalArgumentException(LENGTH_INPUT_ERROR_MESSAGE);
    }

    /* 중복된 차 감지시에 에러 메세지 */
    public static void showCarsInputError() {
        throw new IllegalArgumentException(CARS_INPUT_ERROR_MESSAGE);
    }

    /* 시도 횟수가 정수가 아닐 시에 메세지 */
    public static void showNumberInputError() {
        throw new IllegalArgumentException(NUMBER_INPUT_ERROR_MESSAGE);
    }

    /* 빈 값을 입력했을 떄 나타나는 메세지 */
    public static void showVoidInputError() {
        throw new IllegalArgumentException(VOID_INPUT_ERROR_MESSAGE);
    }
}
