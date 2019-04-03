import java.util.Scanner;

public class InputHandler {
    static final String FIRST_WORD = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    static String getInput() {
        Scanner s = new Scanner(System.in);
        System.out.println(FIRST_WORD);
        return s.nextLine();
    }
}
