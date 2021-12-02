package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String[] names;
    private int times;

    public void enterCarName() {
        String name = Console.readLine();
    }

    public void enterTimes() {
        times = Integer.parseInt(Console.readLine());
    }
}
