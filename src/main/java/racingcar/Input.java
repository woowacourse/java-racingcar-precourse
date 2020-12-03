package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public String[] getCarNameArray(String inputCars) {
        String[] carNames = inputCars.split(",");
        return carNames;
    }

    public List<String> getCarNameList(String inputCars) {
        String[] carNameArray = getCarNameArray(inputCars);
        List<String> carNameList = new ArrayList<>(carNameArray.length);
        for (String carName : carNameArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    public int getTrial(int trial) {
        return trial;
    }


}
