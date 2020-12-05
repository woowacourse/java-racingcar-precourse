package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGenerate {

    public static List<Car> carGenerate(List<String> carNamesSplitList) {
        List<Car> carList = new ArrayList<>();
        for (String s : carNamesSplitList) {
            carList.add(new Car(s));
        }
        return carList;
    }
}
