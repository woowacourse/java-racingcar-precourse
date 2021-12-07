package racingcar;

import camp.nextstep.edu.missionutils.Console;
import constant.ConsoleMessage;

public class GameSystem {
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String ZERO_REGEX = "0+";
    private static final String COMMA_REGEX = ",";
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final CarEntry carEntry;

    public GameSystem() {
        System.out.print(ConsoleMessage.CAR_NAME_INPUT_MESSAGE);
        String carEntryInput = getCarEntryInput();
        carEntry = new CarEntry(carEntryInput);
    }

    public void executeRace() {
        int numOfRuns = getNumOfRuns();

        System.out.println(ConsoleMessage.RESULT_MESSAGE);
        for (int i = 0; i < numOfRuns; i++) {
            runRaceOnce();
        }
        carEntry.printWinners();
    }

    private String getCarEntryInput() {
        String carEntryInput = "";
        boolean isValid;
        do {
            try {
                carEntryInput = Console.readLine();
                isValid = true;
                checkCarNameEntryValidity(carEntryInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ConsoleMessage.CAR_NAME_ERROR_MESSAGE);
                isValid = false;
            }
        } while (!isValid);
        return carEntryInput;
    }

    private void checkCarNameEntryValidity(String carNames) {
        String[] carNameArr = carNames.split(COMMA_REGEX);
        for (String carName : carNameArr) {
            checkCarNameValidity(carName.trim());
        }
    }

    private void checkCarNameValidity(String carName) {
        if (carName.length() <= MAX_CAR_NAME_LENGTH && carName.length() >= MIN_CAR_NAME_LENGTH) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private int getNumOfRuns() {
        boolean isValid;
        String inputValue = "";
        System.out.println(ConsoleMessage.NUN_OF_RUNS_INPUT_MESSAGE);
        do {
            try {
                inputValue = Console.readLine();
                checkNumOfRunsValidity(inputValue);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ConsoleMessage.NUN_OF_RUNS_ERROR_MESSAGE);
                isValid = false;
            }
        } while (!isValid);
        return Integer.parseInt(inputValue);
    }

    void checkNumOfRunsValidity(String inputValue) {
        if (!inputValue.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
        if (inputValue.matches(ZERO_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void runRaceOnce() {
        carEntry.letCarsMove();
        carEntry.printCurCarsPosition();
        System.out.print(ConsoleMessage.NEW_LINE);
    }
}
