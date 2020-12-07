package racingcar.domain.car.carmanager;

import racingcar.domain.car.CarInterface;
import racingcar.domain.car.carfactory.Factory;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<CarInterface> cars;
    private Factory factory;
    private int firstClassPosition;

    public CarManager(Factory factory) {
        this.factory = factory;
        cars = new ArrayList<>();
        this.firstClassPosition = 0;
    }

    public List<CarInterface> orderCar(List<String> carNames) {
        for (int carNumber = 0; carNumber < carNames.size(); carNumber++) {
            CarInterface car = factory.deliverCar(carNames.get(carNumber));
            cars.add(car);
        }
        return cars;
    }

    public void driveAllCarOnce() {
        for (CarInterface car : cars) {
            car.drive();
            if (car.getPosition() > firstClassPosition) {
                firstClassPosition = car.getPosition();
            }
        }
    }

    public List<CarInterface> getHeadCars() {
        List<CarInterface> headCars = new ArrayList<>();
        for (CarInterface car : cars) {
            if (car.getPosition() == this.firstClassPosition) {
                headCars.add(car);
            }
        }
        return headCars;
    }
}
