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
}
