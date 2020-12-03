package utils;

public class Printer {
    public static final String CAR_NAME_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_ROUND_PRINT = "시도할 회수는 몇회인가요?";

    public static void setCarNamePrinter() {
        System.out.println(CAR_NAME_PRINT);
    }

    public static void setPlayRoundPrinter() {
        System.out.println(PLAY_ROUND_PRINT);
    }


}
