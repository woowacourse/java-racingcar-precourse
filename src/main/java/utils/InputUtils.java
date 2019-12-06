package utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return scanner.nextLine();
        } catch (Exception e) {
            return inputCarNames();
        }
    }
}