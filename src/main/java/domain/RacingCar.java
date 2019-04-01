package domain;

import java.util.ArrayList;

public class RacingCar {
    private ArrayList<Car> cars;
    private int tries;
    private int maxLenOfName = 0;

    public RacingCar(ArrayList<Car> cars, int tries) {
        this.cars = cars;
        this.tries = tries;

        calculateMaxLenOfName();

    }

    public void calculateMaxLenOfName() {
        for (Car car : cars) {
            int lenOfName = car.getName().length();
            if (lenOfName > maxLenOfName) {
                maxLenOfName = lenOfName;
            }
        }
    }

    public String getAlignedName(Car car) {
        String name = car.getName();
        while (name.length() < maxLenOfName) {
            name += " ";
        }
        return name;
    }
}
