package racingcar.View;

public class OutputView {
    public static void printInputCarGuideMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printInputNumberGuideMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printExcutionResult() {
        System.out.println("실행 결과");
    }

    public static void printFinalWinnerBy(String[] winnerCarNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
    }
}
