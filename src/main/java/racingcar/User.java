package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String names;
    private int times;
    public String[] nameArray;


    public void enterCarName() {
        names = Console.readLine();
    }

    public void enterTimes() {
        times = Integer.parseInt(Console.readLine());
    }

    public void toNameArray(String names) {
        nameArray = names.split(",");
    }

    public String getCarName() {
        return this.names;
    }

    public int getTimes() {
        return this.times;
    }
}
