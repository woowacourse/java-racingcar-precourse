package view;

public class OutputForNotify {
    private static final String notificationForCarName = "경주 할 자동차의 이름을 입력해주세요 ','를 기준으 구분합니다.";
    private static final String notificationForHowMany = "시도 할 횟수는 몇번인가요?";
    private static final String carNameInputError = "각 자동차의 이름은 5글자 이하로만 가능합니다. ','를 기준으로 입력해주세요.";
    private static final String formatError = "올바르지 않은 입력입니다. 원하는 횟수를 숫자로 입력해주세요.";
    private static final String gameResult = "실행 결과";
    private static final String NEXT_LINE = "\n";

    public static void notifyCarName() {
        System.out.println(notificationForCarName);
    }

    public static void notifyHowManyTimes() {
        System.out.println(notificationForHowMany);
    }

    public static void notifyCarNameError() {
        System.out.println(carNameInputError);
    }
    public static void notifyFormatError(){
        System.out.println(formatError);
    }

    public static void gameResult() {
        System.out.println(gameResult);
    }

    public static void nextLine(){
        System.out.print(NEXT_LINE);
    }
}
