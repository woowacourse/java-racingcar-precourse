package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarRacing {

    private static ArrayList<Car> getCarName(String carName) {
        List<String> name = Arrays.asList(carName.split(","));
        ArrayList<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < name.size(); i ++) {
            carList.add(new Car(name.get(i)));
        }
        return carList;
    }

}
