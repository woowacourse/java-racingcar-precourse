package racingcar.model;

import racingcar.Constants;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String userInput) {
        isValidUserNames(userInput);
        List<Car> cars = new ArrayList<>();
        String[] users = userInput.split(Constants.COMMA);

        for (String user : users) {
            Car raceCar = new Car(user);
            cars.add(raceCar);
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
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

    public void isValidUserNames(String userNamesInput) {
        String[] users = userNamesInput.split(Constants.COMMA);

        if (users.length <= 1) {
            throw new IllegalArgumentException();
        }

        for (String user : users) {
            user = user.trim();

            if (user.length() > Constants.MAX_LENGTH_USER_NAME) {
                throw new IllegalArgumentException();
            }
        }
    }
}
