package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    CarEntry carEntry;

    public GameSystem() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        carEntry = new CarEntry(Console.readLine());
    }

    public void executeRace() {
        System.out.println("시도할 회수는 몇회인가요?");
        int nOfRuns = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < nOfRuns; i++){
            runRaceOnce();
        }
        carEntry.printWinners();
    }

    private void runRaceOnce() {
        carEntry.letCarsMove();
        carEntry.printCurCarsPosition();
        System.out.print("\n");
    }
}
