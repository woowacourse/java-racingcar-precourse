package domain;

import java.util.List;

public class CarSetting {
    private Car[] cars;
    private int count;

    void carSet() {
        String[] names = Naming.inputNames();
        cars = new Car[names.length];
        for(int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        count = Count.inputCount();
    }

    Car[] getCars() {
        return cars;
    }

    int getCount() {
        return count;
    }
}
