package racingcar.game;

import java.util.ArrayList;
import racingcar.Car;
import utils.RandomUtils;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }

    public void startRacing(int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            goForward();
            System.out.println();
        }
    }

    private void goForward() {
        for (Car car : cars) {
            int numberToGoForward = RandomUtils.nextInt(0, 9);
            car.goForward(numberToGoForward);
            car.printCurrentState();
            System.out.println();
        }
    }
}
