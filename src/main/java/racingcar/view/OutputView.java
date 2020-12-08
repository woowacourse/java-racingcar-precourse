package racingcar.view;

public class OutputView {
    private final String ASK_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ERROR_INVALID_NAME_MSG = "[ERROR]자동차 이름이 잘못 입력되었습니다.";
    private final String ERROR_INVALID_TIME_MSG = "[ERROR]시도 횟수는 숫자여야 합니다.";
    private final String ASK_TIME_MSG = "시도할 횟수는 몇회인가요?";
    private final String RESULT_MSG = "실행 결과";
    private final String WINNER_MSG = "최종 우승자 : ";

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

    public void resultMessage() {
        System.out.println(RESULT_MSG);
    }

    public void showPosition(String information) {
        System.out.println(information);
        System.out.println();
    }

    public void showWinner(String result) {
        System.out.print(WINNER_MSG);
        System.out.print(result);
    }
}
