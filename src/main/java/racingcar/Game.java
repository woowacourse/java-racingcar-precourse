package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Car> makeCarObject(String[] allCarName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public void runCarRacingOneRound(List<Car> cars) {
        for (Car car : cars) {
            car.predicateAdvance();
            System.out.print(car.getName() + " : ");
            showEachCarPosition(car.getPosition());
            System.out.println();
        }
    }

    private void showEachCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public int getFrontPosition(List<Car> cars) {
        int frontPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > frontPosition) {
                frontPosition = car.getPosition();
            }
        }
        return frontPosition;
    }

    public List<String> getWinner(List<Car> cars, int frontPosition) {
        List<String> winnersName = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == frontPosition) {
                winnersName.add(car.getName());
            }
        }

        return winnersName;
    }
}
