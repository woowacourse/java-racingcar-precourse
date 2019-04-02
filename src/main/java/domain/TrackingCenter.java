package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class TrackingCenter {
    private HashMap<String, Integer> realTimePositionsOfCars = new HashMap<String, Integer>();

    public void detectPositions(ArrayList<Car> cars) {
        for (Car car: cars) {
            realTimePositionsOfCars.put(car.getName(), car.getPosition());
        }
    }

    public void showPositions() {

    }

    public void showRanks() {

    }

    public void showWinners() {

    }
}