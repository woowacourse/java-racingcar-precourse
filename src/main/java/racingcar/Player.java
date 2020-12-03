package racingcar;

import utils.ValidationUtils;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private String[] carNameArray;
    private String tryNumber;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        this.tryNumber = "";
    }

    public void inputCarNameArray() {
        this.carNameArray = splitCarNamesWithComma(scanner.nextLine());
    }

    public String getTryNumber() {
        this.tryNumber = scanner.nextLine();
        return tryNumber;
    }

    public String[] splitCarNamesWithComma(String carNames) {
        String[] splitCarNameResultArray = carNames.split(",");
        ValidationUtils.validateCarNameArray(splitCarNameResultArray);
        return splitCarNameResultArray;
    }
}