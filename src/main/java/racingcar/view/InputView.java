package racingcar.view;

public class InputView {
    private static final String INPUT_CAR_NAME_LOG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_NUM_LOG = "시도할 회수는 몇회인가요?";

    public static void printCarNameInputLog(){
        System.out.println(INPUT_CAR_NAME_LOG);
    }

    public static void printRaceNumInputLog(){
        System.out.println(INPUT_RACE_NUM_LOG);
    }
}
