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
        splitCarNamesWithComma(scanner.nextLine());
        System.out.println(carNameArray[0]);
        return carNameArray;
    }

    public String getTryNumber() {
        this.tryNumber = scanner.nextLine();
        return tryNumber;
    }

    public void splitCarNamesWithComma(String carNames) {
        carNameArray = carNames.split(",");
        ValidationUtils.validateCarNameArray(carNameArray);
    }
}
