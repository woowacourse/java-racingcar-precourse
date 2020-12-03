package racingcar.consol;

import utils.ValidationUtils;
import java.util.Scanner;

public class InputConsole {
    private final Scanner scanner;
    private String[] carNameArray;
    private String tryNumber;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
        this.tryNumber = "";
    }

    public String[] getCarNameArray() {
        return carNameArray;
    }

    public String getTryNumber() {
        this.tryNumber = scanner.nextLine();
        return tryNumber;
    }

    public void splitCarNamesWithComma(String carNames) {
    }
}
