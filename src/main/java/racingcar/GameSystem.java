package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    CarEntry carEntry;

    public GameSystem() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carEntryInput = getCarEntryInput();
        carEntry = new CarEntry(carEntryInput);
    }

    public void executeRace() {
        int numOfRuns = getNumOfRuns();

        System.out.println("\n실행 결과");
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
                System.out.println("[ERROR] 이름의 길이는 1 이상 5 이하이어야 합니다.");
                isValid = false;
            }
        } while (!isValid);
        return carEntryInput;
    }

    private void checkCarNameEntryValidity(String carNames) {
        String[] carNameArr = carNames.split(",");
        for (String carName : carNameArr) {
            checkCarNameValidity(carName.trim());
        }
    }

    private void checkCarNameValidity(String carName) {
        if (carName.length() <= 5 && carName.length() >= 1) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private int getNumOfRuns() {
        boolean isValid;
        String inputValue = "";
        System.out.println("시도할 회수는 몇회인가요?");
        do {
            try {
                inputValue = Console.readLine();
                checkNumOfRunsValidity(inputValue);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도할 회수는 0 이상의 정수이어야 합니다.");
                isValid = false;
            }
        } while (!isValid);
        return Integer.parseInt(inputValue);
    }

    void checkNumOfRunsValidity(String inputValue) {
        if (inputValue.matches("[^0-9]+")) {
            throw new IllegalArgumentException();
        }
        if (inputValue.matches("0+")) {
            throw new IllegalArgumentException();
        }
    }

    private void runRaceOnce() {
        carEntry.letCarsMove();
        carEntry.printCurCarsPosition();
        System.out.print("\n");
    }
}
