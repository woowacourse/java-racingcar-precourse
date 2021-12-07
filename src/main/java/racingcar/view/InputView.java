package racingcar.view;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputRoundsMessage() {
        System.out.println(INPUT_PLAY_ROUND_MESSAGE);
    }
}
