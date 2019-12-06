package controll;

import domain.Car;
import io.IoSystem;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Car> cars;
    private ArrayList<Car> resultCars;

    public Controller() {

    }

    private int getRandomInt() {
        return (int) (Math.random() * 10);
    }

    public void stringCommaSplit(String carListText) {
        // 길이가 6자 이상인 경우 예외처리가 필요하다.
        for (String st : carListText.split(",")) {
            cars.add(new Car(st));
        }
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

    private void getMaximumDistanceCars(int length) {
        for (int i = 0; i < cars.size(); i++) {
            // 최장거리라면?
            if (length == cars.get(i).getPosition()) {
                resultCars.add(cars.get(i));
            }
        }
    }

    public void getMaximumDistanceCar() {
        int index = 0;
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(index).getPosition() < cars.get(i).getPosition()) {
                index = i;
            }
        }
        getMaximumDistanceCars(cars.get(index).getPosition());
    }

    public ArrayList<Car> getResultCars() {
        return resultCars;
    }
}