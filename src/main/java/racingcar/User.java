package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String names;
    private int times;


    public void enterCarName() {
        names = Console.readLine();
    }

    public void enterTimes() {
        times = Integer.parseInt(Console.readLine());
    }

    public String getCarName() {
        return this.names;
    }

    public int getTimes() {
        return this.times;
    }
}
