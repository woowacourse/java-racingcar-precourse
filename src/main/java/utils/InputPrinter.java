package utils;

public class InputPrinter {
    public static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ROUND_INPUT = "시도할 회수는 몇회인가요?";

    public static void inputCarPrint() {
        System.out.println(CAR_NAME_INPUT);
    }

    public static void inputRaceRoundPrint() {
        System.out.println(RACE_ROUND_INPUT);
    }
}
