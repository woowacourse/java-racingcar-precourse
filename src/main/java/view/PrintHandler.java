package view;

import java.util.List;

import domain.model.Vehicle;

/**
 * @author 김시영
 * @apiNote 출력과 관련된 모든 메서드이 모여있는 클래스입니다.
 * @apiNote 입력 규칙을 알려주거나 , 우승자 및 현재 유저들의 position을 출력하는 메서드로 구성되어 있습니다.
 * @since 2019-12-05
 */
public class PrintHandler {
    private static final String NEXT_LINE = "\n";
    private static final String COMMA = ", ";
    private static final String NOTIFICATION_FOR_CAR_NAME = "경주 할 자동차의 이름을 입력해주세요 ','를 기준으 구분합니다.";
    private static final String NOTIFICATION_FOR_HOW_MANY = "시도 할 횟수는 몇번인가요?";
    private static final String CAR_NAME_INPUT_ERROR = "각 자동차의 이름은 1글자 이상 5글자 이하로만 가능합니다. ','를 기준으로 입력해주세요.";
    private static final String FORMAT_ERROR = "올바르지 않은 입력입니다. 원하는 횟수를 1보다 큰 자연수로 입력해주세요.";
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종우승자는 : ";
    private static final String HERE = " 입니다.";


    public static void notifyCarNameRule() {
        System.out.println(NOTIFICATION_FOR_CAR_NAME);
    }

    public static void notifyHowManyTimes() {
        System.out.println(NOTIFICATION_FOR_HOW_MANY);
    }

    public static void notifyCarNameError() {
        System.out.println(CAR_NAME_INPUT_ERROR);
    }

    public static void notifyFormatError() {
        System.out.println(FORMAT_ERROR);
    }

    public static void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void nextLine() {
        System.out.print(NEXT_LINE);
    }

    public static void printLocations(Vehicle user) {
        System.out.println(user.toString());
    }

    public static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER);
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if (i != (winners.size() - 1))
                sb.append(COMMA);
        }
        sb.append(HERE);
        System.out.println(sb.toString());
    }
}
