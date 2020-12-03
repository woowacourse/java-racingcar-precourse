package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER_FOR_NAME = ",";
    private static final String MISMATCH_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputName() {
        Printer.printInputCarName();
        String names = scanner.nextLine();
        try {
            String[] splitNames = splitNames(names);
            return splitNames;
        } catch (IllegalStateException e){
            Printer.printErrorMessage(e.getMessage());
            return inputName();
        }
    }

    private String[] splitNames(String names) {
        String[] splitName = names.split(DELIMITER_FOR_NAME);
        for (String name : splitName) {
            NameValidator.validate(name.trim());
        }
        return splitName;
    }

    public int inputRound(){
        Printer.printInputRound();
        try {
            int round = scanner.nextInt();
            return round;
        } catch (InputMismatchException e) {
            scanner.nextLine(); //개행 문자 버그를 막기 위해
            Printer.printErrorMessage(MISMATCH_MESSAGE);
            return inputRound();
        }
    }
}
