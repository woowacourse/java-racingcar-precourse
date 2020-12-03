package racingcar.game.io.print;

public class InputPrint {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_TIME_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    
    public static void printMessageForInputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void printMessageForInputTryTimes() {
        System.out.println(TRY_TIME_INPUT_MESSAGE);
    }
}
