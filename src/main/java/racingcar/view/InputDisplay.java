package racingcar.view;

public class InputDisplay {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputRoundMessage() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

}
