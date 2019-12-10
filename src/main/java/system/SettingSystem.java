package system;

import domain.Car;
import domain.RacingCars;
import io.InputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SettingSystem {
    public RacingCars setRacingCars() {
        List<Car> cars = new LinkedList<>();
        createRacingCars(cars);
        return new RacingCars(cars);
    }

    private void createRacingCars(List<Car> cars) {
        String carsName = InputRacingCar.inputCarsName();
        StringTokenizer st = splitCarName(carsName);
        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            addCar(cars, carName);
        }
    }

    private StringTokenizer splitCarName(String carsName) {
        return new StringTokenizer(carsName, ",");
    }

    private void addCar(List<Car> cars, String carName) {
        cars.add(new Car(carName));
    }
}