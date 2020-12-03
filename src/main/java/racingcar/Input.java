package racingcar;

import java.util.Scanner;

public class Input {

    public String[] makeCarNameArray(String inputCars) {
        String[] carNames = inputCars.split(",");
        return carNames;
    }
}
