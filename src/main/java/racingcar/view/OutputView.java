package racingcar.view;

public class OutputView {

    private static final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_TRY = "시도할 회수는 몇회인가요?";

    public void printInputCarName() {
        System.out.println(MESSAGE_INPUT_CAR_NAME);
    }

    public void printExceptionMessage(IllegalArgumentException exceptionMessage) {
        exceptionMessage.printStackTrace();
    }

    public void printInputTry() {
        System.out.println(MESSAGE_INPUT_TRY);
    }

    public void printBlank() {
        System.out.println();
    }
}
