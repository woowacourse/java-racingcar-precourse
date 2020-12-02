package racingcar.controller;

public class OutputViewer {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    void printExceedMaxLenCarNameErrorMessage() {
        System.out.println(ERROR_MESSAGE_PREFIX + "최대 자동차 이름 길이를 넘겼습니다.");
    }

    void printErrorInputType() {
        System.out.println(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 한다.");
    }
}
