package racingcar.view;

public class OutputView {

    private static final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void printInputCarName() {
        System.out.println(MESSAGE_INPUT_CAR_NAME);
    }

    public void printExceptionMessage(IllegalArgumentException exceptionMessage) {
        exceptionMessage.printStackTrace();
    }
}
