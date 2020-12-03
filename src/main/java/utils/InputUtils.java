package utils;

import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;

    private InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputUtils of(Scanner scanner) {
        return new InputUtils(scanner);
    }

    private String getNextLine() {
        return scanner.nextLine();
    }

    public String inputAndReturnCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carName = getNextLine();
        return carName;
    }
}
