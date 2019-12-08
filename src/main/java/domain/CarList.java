package domain;

import java.util.ArrayList;

public class CarList {

    private static ArrayList<Car> carList;

    public CarList() {
        this.carList = new CarNameCheck().splitCarName();
    }

    private static boolean isSamePosition(Car carA, Car carB) {
        return (carA.getPosition() == carB.getPosition());
    }


}
