package domain;

public class OutputPrint {

    public void insertName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void howManyTry() {
        println("시도할 회수는 몇 회인가요?");
    }

    public void executeResult() {
        println("\n실행결과");
    }

    void finalWinner(String name) {
        println(name + "(이)가 최종 우승했습니다.");
    }

    private static void println(String string) {
        System.out.println(string);
    }

}
