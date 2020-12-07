package racingcar;

import java.util.ArrayList;

public class View {
    private static final String PLEASE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLEASE_INPUT_LOOP_TIME = "시도할 회수는 몇회인가요?";
    private static final String ERROR = "[ERROR] ";
    private static final String WINNER = "최종 우승자: ";
    private static final String JOIN_COMMA = ", ";
    private static final String START_RACING = "\n실행 결과";

    private View() {
    }

    public static void printPleaseInputCars() {
        System.out.println(PLEASE_INPUT_CAR_NAMES);
    }

    public static void printPleaseInputLap() {
        System.out.println(PLEASE_INPUT_LOOP_TIME);
    }

    public static void printStartRacing() {
        System.out.println(START_RACING);
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.println(WINNER + String.join(JOIN_COMMA, winners));
    }


    public static void printRacing(StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
