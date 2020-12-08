package Domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();
    private int carNum = 0;

    public Cars(List<String> carNames) {
        this.carNum = carNames.toArray().length;
        this.createCars(carNames);
    }

    public void createCars(List<String> carNames) {
        for(int index = 0; index < this.carNum; index += 1) {
            this.cars.add(new Car(carNames.get(index)));
        }
    }

    public Car getCar(int location) {
        return this.cars.get(location);
    }

    public int getCarNum() {
        return this.carNum;
    }

    public int getMaxScore() {
        return this.cars.stream()
               .mapToInt(Car::getScore)
               .max()
               .getAsInt();
    }

}
