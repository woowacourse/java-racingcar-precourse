package racingcar.garage;

import racingcar.Car;

import java.util.List;

public class Garage {
    private final List<Car> carList;

    public Garage(List<Car> carList) {
        this.carList = carList;
    }

    public static Garage from(List<Car> carSet) {
        return new Garage(carSet);
    }

    public boolean containsCar(Car car) {
        return carList.contains(car);
    }

    public String getRoundResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : carList) {
            stringBuilder.append(car.whereIsIt() + '\n');
        }

        return stringBuilder.toString();
    }
}
