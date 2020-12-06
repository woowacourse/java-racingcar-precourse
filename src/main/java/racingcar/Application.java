package racingcar;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        displayCarNameInputMessage();
        inputCarNames(scanner);
        scanner.close();
    }

    private static void displayCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void inputCarNames(Scanner kbd) {
        String input = kbd.nextLine();
        StringTokenizer tokens = new StringTokenizer(input, ", ");
        int countTokens = tokens.countTokens();
        String[] names = new String[countTokens];
        for (int i = 0; i < countTokens; i++) {
            names[i] = tokens.nextToken();
        }
    }
}
