package View;

public class OutputView {
    private static final String WRITE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String WRITE_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public static void writeTryNumber(){
        print(WRITE_TRY_NUMBER);
    }

    public static void writeCarName() {
        print(WRITE_CAR_NAME);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
