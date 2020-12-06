package racingcar.view;

import racingcar.exception.NameLengthOutOfBoundsException;
import racingcar.exception.EmptyNameException;
import racingcar.exception.OverlapNameException;
import racingcar.exception.AttemptCountTypeException;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String REINPUT_MESSAGE = "다시 입력하십시오.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> scanCarName() {
        printNameInputMessage();
        List<String> nameList = splitInputToName(scanUserInput());
        while (!isValidNameList(nameList)) {
            printReInputMessage();
            nameList = splitInputToName(scanUserInput());
        }
        return nameList;
    }

    public int scanAttemptCount() {
        printAttemptCountInputMessage();
        String attemptCount = scanUserInput();
        while (!isValidAttemptCount(attemptCount)) {
            printReInputMessage();
            attemptCount = scanUserInput();
        }
        return Integer.parseInt(attemptCount);
    }

    private void printNameInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    private void printAttemptCountInputMessage() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
    }

    private String scanUserInput() {
        return this.scanner.nextLine();
    }

    private List<String> splitInputToName(String inputNameList) {
        List<String> names = Arrays.asList(inputNameList.split(","));
        return names;
    }

    private boolean isValidNameList(List<String> nameList) {
        try {
            validationNameList(nameList);
            return true;
        } catch(RuntimeException errorMessage) {
            System.out.println(errorMessage);
            return false;
        }
    }

    private boolean isValidAttemptCount(String attemptCount) {
        try{
            validationCountNumber(attemptCount);
            return true;
        } catch (AttemptCountTypeException errorMessage) {
            System.out.println(errorMessage);
            return false;
        }
    }

    private boolean validationNameList(List<String> nameList) {
        for (int idx = 0; idx < nameList.size(); idx++) {
            if (!validationNameLength(nameList.get(idx))) {
                throw new NameLengthOutOfBoundsException();
            }
            if (!validationEmptyName(nameList.get(idx))) {
                throw new EmptyNameException();
            }
        }
        if (!validationOverlapName(nameList)) {
            throw new OverlapNameException();
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

    private boolean validationOverlapName(List<String> nameList) {
        HashSet<String> names = new HashSet<String>(nameList);
        if (names.size() == nameList.size()) {
            return true;
        }
        return false;
    }

    private boolean validationCountNumber(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
            return true;
        } catch (NumberFormatException e) {
            throw new AttemptCountTypeException();
        }
    }

    private void printReInputMessage() {
        System.out.println(REINPUT_MESSAGE);
    }
}