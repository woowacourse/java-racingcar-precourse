package domain;

import java.util.ArrayList;

public class CarGenerator {
    private ArrayList<Car> carList = new ArrayList<>();

    public void GenerateCar(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
    }
}
