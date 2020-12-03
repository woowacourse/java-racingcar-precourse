package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public String[] makeCarNameArray(String inputCars) {
        String[] carNames = inputCars.split(",");
        return carNames;
    }

    public List<String> makeCarNameList(String inputCars) {
        String[] carNameArray = makeCarNameArray(inputCars);
        List<String> carNameList = new ArrayList<>(carNameArray.length);
        for (String carName : carNameArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }
}
