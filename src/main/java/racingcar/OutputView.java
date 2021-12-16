package racingcar;

public class OutputView {
    public static final String INTRO_INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INTRO_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INTRO_WINNER = "최종 우승자 : ";
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void print(String data) {
        System.out.print(data);
    }

    public static void println(String data) {
        System.out.println(data);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printError(String error) {
        System.out.println(ERROR_PREFIX + error);
    }
}
