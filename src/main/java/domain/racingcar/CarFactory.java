package domain.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private List<Car> cars;

    public void makeCars(List<String> carNames){
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
