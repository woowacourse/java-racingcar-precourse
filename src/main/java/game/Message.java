package game;

/**
 * @author yhh1056
 * @since 2020/12/05
 */
public class Message {
    public static final String INPUT_NAME_MESSAGE =
        "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종우승자: ";
    public static final String WINNER_DELIMITER = ", ";
    public static final String COLON = " : ";

    private Message() {
    }

    public static String showWinners(String name, String state) {
        return name + COLON + state;
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String outputMessage) {
        System.out.println(outputMessage);
    }
}
