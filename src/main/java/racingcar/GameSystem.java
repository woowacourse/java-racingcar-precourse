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
        System.out.println("시도할 회수는 몇회인가요?");
        int nOfRuns = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < nOfRuns; i++) {
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

    private void runRaceOnce() {
        carEntry.letCarsMove();
        carEntry.printCurCarsPosition();
        System.out.print("\n");
    }
}
