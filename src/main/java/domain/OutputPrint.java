package domain;

public class OutputPrint {

    public void insertName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void println(String string) {
        System.out.println(string);
    }

}
