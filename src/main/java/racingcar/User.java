package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static final String NAMES_SPLIT_DELIMITER = ",";

    private String names;
    private String inputTimes;
    private int times;
    public String[] nameArray;


    public void enterCarName() {
        names = Console.readLine();
    }

    public void enterTimes() {
        inputTimes = Console.readLine();
    }

    public void toIntegerTimes() {
        this.times = Integer.parseInt(this.inputTimes);
    }

    public void toNameArray() {
        nameArray = this.names.split(NAMES_SPLIT_DELIMITER);
    }

    public String[] getCarName() {
        return this.nameArray;
    }

    public String getInputTimes() {
        return this.inputTimes;
    }

    public int getTimes() {
        return this.times;
    }
}
