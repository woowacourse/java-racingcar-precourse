package racingcar.view;

import racingcar.exception.NameLengthOutOfBoundsException;
import racingcar.exception.EmptyNameException;

import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REINPUT_MESSAGE = "다시 입력하십시오.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] scanCarName() {
        printNameInputMessage();
        String[] nameList = splitInputToName(scanUserInput());
        while (!isValidNameList(nameList)) {
            printReInputMessage();
            nameList = splitInputToName(scanUserInput());
        }
        return nameList;
    }

    private void printNameInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    private String scanUserInput() {
        return this.scanner.nextLine();
    }

    private String[] splitInputToName(String inputNameList) {
        String[] names = inputNameList.split(",");
        return names;
    }

    private boolean isValidNameList(String[] nameList) {
        try {
            validationNameList(nameList);
            return true;
        } catch(RuntimeException errorMessage) {
            System.out.println(errorMessage);
            return false;
        }
    }

    private boolean validationNameList(String[] nameList) {
        for (int idx = 0; idx < nameList.length; idx++) {
            if (!validationNameLength(nameList[idx])) {
                throw new NameLengthOutOfBoundsException();
            }
            if (!validationEmptyName(nameList[idx])) {
                throw new EmptyNameException();
            }
        }
        return true;
    }

    private boolean validationNameLength(String name) {
        if (name.length() <= MAX_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean validationEmptyName(String name) {
        if (name.trim().length() < MIN_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    private void printReInputMessage() {
        System.out.println(REINPUT_MESSAGE);
    }
}