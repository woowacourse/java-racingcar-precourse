package racingcar.view;

public class Output {
    private static final String CARS_NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REPETITION_NUMBER_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private Output() {
    }

    public static void CarNameInputGuideMessage() {
        System.out.println(CARS_NAME_INPUT_GUIDE_MESSAGE);
    }

    public static void NumberInputGuideMessage() {
        System.out.println(REPETITION_NUMBER_INPUT_GUIDE_MESSAGE);
    }
}
