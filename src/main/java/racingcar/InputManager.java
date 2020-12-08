package racingcar;

import utils.ValidationUtils;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;
    private String[] carNameArray;
    private String inputCarNames;
    private String inputTryNumberString;
    private int tryNumber;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputCarNameArray() {
        inputCarNames = scanner.nextLine();
        splitCarNamesWithComma();
    }

    public void inputTryNumber() {
        inputTryNumberString = scanner.nextLine();
        ValidationUtils.validateTryNumber(inputTryNumberString);
        stringToInteger(inputTryNumberString);
    }

    public void splitCarNamesWithComma() {
        carNameArray = inputCarNames.split(",",-1);
        ValidationUtils.validateCarNameArray(carNameArray);
    }

    public void stringToInteger(String inputTryNumber) {
        tryNumber = Integer.parseInt(inputTryNumber);
    }

    public String[] getCarNameArray() {
        return carNameArray;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}