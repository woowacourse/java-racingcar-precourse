package domain;

import java.util.ArrayList;

public class CarRepository {
    public static ArrayList<Car> carPark = new ArrayList<>();

    public static void parking(Car car){
        carPark.add(car);
    }
}
