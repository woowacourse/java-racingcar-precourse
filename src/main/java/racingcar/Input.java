package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public String[] getCarNameArray(Scanner scanner) {
        String inputCars = scanner.next();
        String[] carNames = inputCars.split(",");
        return carNames;
    }

    public List<String> getCarNameList(String[] carNameArray) {
        List<String> carNameList = new ArrayList<>(carNameArray.length);
        for (String carName : carNameArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    public int getTrial(Scanner scanner) {
        int trial = scanner.nextInt();
        return trial;
    }


}
