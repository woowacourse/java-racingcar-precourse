package Race;

import racingcar.Car;

import java.util.List;

public class Race {

    private List<Car> Cars;
    private int carNum = 0;

    Race(List<String> carNames) {
        createCars(carNames);
    }

    void createCars(List<String> carNames) {
        this.carNum = carNames.toArray().length;

        for(int index = 0; index < this.carNum; index += 1) {
            this.Cars.add(new Car(carNames.get(index)));
        }
    }
}
