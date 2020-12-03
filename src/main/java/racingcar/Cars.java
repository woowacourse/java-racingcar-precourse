package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public void makeCars(String userInput) {
        String[] users = userInput.split(Constants.COMMA);

        for (String user : users) {
            Car raceCar = new Car(user);
            addCar(raceCar);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void addCar(Car car) {
        this.cars.add(car);
    }

    public void runCars() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public ArrayList<Integer> getCarsPosition() {
        ArrayList<Integer> carsPosition = new ArrayList<>();

        for (Car car : cars) {
            carsPosition.add(car.getPosition());
        }

        return carsPosition;
    }

    public ArrayList<String> getCarsName() {
        ArrayList<String> carsName = new ArrayList<>();

        for (Car car : cars) {
            carsName.add(car.getName());
        }

        return carsName;
    }

    public void selectWinners() {
        int winnerPosition = Collections.max(getCars()).getPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {

            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }

        }
        this.cars = winners;
    }
}
