package View;

public class OutputView {
    private static final String WRITE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void writeCarName() {
        print(WRITE_CAR_NAME);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
