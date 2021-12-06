package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    public void play() {

    }

    private String[] getRacePlayerNames() {
        String input = Console.readLine();
        String[] names = input.split(", ");

        return names;
    }
}
