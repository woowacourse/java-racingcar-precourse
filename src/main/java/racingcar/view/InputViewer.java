package racingcar.view;

public class InputViewer {
    private static final String CARS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    /* 초기 차들의 이름을 받는 메세지 */
    public static void carsInput() {
        System.out.println(CARS_INPUT_MESSAGE);
    }

    /* 경주 횟수를 묻는 메세지 */
    public static void numberInput() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }
}
