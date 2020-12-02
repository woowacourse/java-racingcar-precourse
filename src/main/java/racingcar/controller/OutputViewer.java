package racingcar.controller;

public class OutputViewer {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    void printExceedMaxLenCarNameErrorMessage() {
        System.out.println(ERROR_MESSAGE_PREFIX + "최대 자동차 이름 길이를 넘겼습니다.");
    }

    void printErrorInputTypeMessage() {
        System.out.println(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 한다.");
    }

    void printInputHowManyTryMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
