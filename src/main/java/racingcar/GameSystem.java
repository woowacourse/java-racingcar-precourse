package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {
    CarEntry carEntry;

    public GameSystem() {
        carEntry = new CarEntry(Console.readLine());
    }
}
