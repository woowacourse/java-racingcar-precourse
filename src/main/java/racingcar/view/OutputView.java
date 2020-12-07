package racingcar.view;

public class OutputView {
    private final String ASK_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ERROR_INVALID_NAME_MSG = "[ERROR]자동차 이름이 잘못 입력되었습니다.";
    private final String ERROR_INVALID_TIME_MSG = "[ERROR]시도 횟수는 숫자여야 합니다.";
    private final String ASK_TIME_MSG = "시도할 횟수는 몇회인가요?";

    public void askCarName() {
        System.out.println(ASK_CAR_NAME_MSG);
    }

    public void errorInvalidName() {
        System.out.println(ERROR_INVALID_NAME_MSG);
    }

    public void askTime() {
        System.out.println(ASK_TIME_MSG);
    }

    public void errorInvalidTime() {
        System.out.println(ERROR_INVALID_TIME_MSG);
    }
}
