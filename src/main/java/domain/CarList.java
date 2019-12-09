package domain;

import java.util.ArrayList;

public class CarList {
    ArrayList<Car> car = new ArrayList<Car>();

    public CarList(String[] names) {
        int numberOfCar = names.length;
        for (String name : names) {
            car.add(new Car(name));
        }
    }

    public void printCarList() {
        for (Car it : car) {
            System.out.print(it.getName() + ": ");
            for (int i = 0; i < it.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
