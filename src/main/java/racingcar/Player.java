package racingcar;

import utils.ValidationUtils;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private String[] carNameArray;
    private int tryNumber;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputCarNameArray() {
        this.carNameArray = splitCarNamesWithComma(scanner.nextLine());
    }

    public void inputTryNumber() {
        this.tryNumber = ValidationUtils.validateTryNumber(scanner);
    }

    public String[] splitCarNamesWithComma(String carNames) {
        String[] splitCarNameResultArray = carNames.split(",");
        ValidationUtils.validateCarNameArray(splitCarNameResultArray);
        return splitCarNameResultArray;
    }

    public String[] getCarNameArray() {
        return carNameArray;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}