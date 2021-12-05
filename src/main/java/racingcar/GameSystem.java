package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    CarEntry carEntry;

    public GameSystem() {
        carEntry = new CarEntry(Console.readLine());
    }

    public void executeRace() {
        System.out.println("시도할 회수는 몇회인가요?");
        int nOfRuns = Integer.parseInt(Console.readLine());
        for (int i = 0; i < nOfRuns; i++){
            runRaceOnce();
        }
        carEntry.printWinners();
    }

    private void runRaceOnce() {
        //TODO
    }
}
