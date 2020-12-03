package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public void makeCars(String userInput){
        String[] users = userInput.split(",");

        for (String user : users) {
            Car raceCar = new Car(user);
            addCars(raceCar);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(Car car){
        this.cars.add(car);
    }

}
