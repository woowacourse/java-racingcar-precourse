package domain;

import java.util.ArrayList;

public class CarList {

    private static ArrayList<Car> carList;

    public CarList() {
        this.carList = new CarNameCheck().splitCarName();
    }

}
