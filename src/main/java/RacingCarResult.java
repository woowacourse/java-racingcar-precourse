import domain.Car;

import java.util.List;

public class RacingCarResult {
    private List<Car> cars;

    public RacingCarResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
} 
