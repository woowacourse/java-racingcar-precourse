package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGenerate {

    public static List<Car> carGenerate(List<String> carNamesSplitList) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNamesSplitList.size(); i++) {
            carList.add(new Car(carNamesSplitList.get(i)));
        }
        return carList;
    }
}
