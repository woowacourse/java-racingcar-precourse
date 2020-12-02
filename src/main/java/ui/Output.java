package ui;

public class Output {
    public static void printRequestRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestAttemptsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void willPrintResult() {
        System.out.println("실행 결과");
    }

    public static void printResult(String name, int position) {
        String movingResult = "";
        for (int i = 0; i < position; i++) {
            movingResult += "-";
        }
        System.out.println(name + " : " + movingResult);
    }
}
