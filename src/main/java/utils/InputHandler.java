package utils;

import java.util.Scanner;


public class InputHandler {

    private final Scanner scanner;
    private static final int carNameLimit = 5;
    private static final String carNameInputSplitter = ",";

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    private String[] carNameParser() throws IllegalArgumentException {
        String input = scanner.next();
        String[] carNames = input.split(carNameInputSplitter);
        for (String carName : carNames) {
            if (carName.length() > carNameLimit) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public String[] getValidCarNames() {
        while (true) {
            try {
                System.out.println(SysMessages.carNameInputMessage);
                return carNameParser();
            } catch (IllegalArgumentException e) {
                System.out.println(SysMessages.carNameErrorMessage);
            }
        }
    }

    public int getValidRoundCount() {
        while (true) {
            try {
                System.out.println(SysMessages.roundNumberInputMessage);
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println(SysMessages.roundNumberErrorMessage);
            }
        }
    }

}