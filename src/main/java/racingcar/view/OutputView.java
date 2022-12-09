package racingcar.view;

public class OutputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "자동차 이름을 5자 이하로 콤마로 구분하여 입력해주세요.";
    private static final String INPUT_TRIAL_MESSAGE = "시도할 횟수를 입력해주세요.";

    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTrialMessage() {
        System.out.println(INPUT_TRIAL_MESSAGE);
    }
}
