package util;

import java.util.ArrayList;

import domain.Car;

public class MakeCar {

    public static ArrayList<Car> carArray = new ArrayList<>();

    public static void makingCar() {
        String[] nameArray = NameInput.getCarName();
        for (String name : nameArray) {
            carArray.add(new Car(name));
        }
    }
}
