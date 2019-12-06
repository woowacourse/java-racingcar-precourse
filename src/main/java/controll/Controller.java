package controll;

import domain.Car;
import io.IoSystem;
import java.util.ArrayList;

class Controller {

    private ArrayList<Car> cars;
    private ArrayList<Car> resultCars;

    Controller() {

    }

    private int getRandomInt() {
        return (int) (Math.random() * 10);
    }

    public void stringCommaSplit(String carListText) {
        carListText.split(",");
    }

    public void runCarsForward() {
        for (int i = 0; i < this.cars.size(); i++) {
            if (getRandomInt() >= 4) {
                cars.get(i).setForward();
            }
        }
    }

    public void runCarsPirnt() {
        for (int i = 0; i < this.cars.size(); i++) {
            cars.get(i).positionPrint();
        }
    }

    public void getMaximumDistanceCar() {

    }
}