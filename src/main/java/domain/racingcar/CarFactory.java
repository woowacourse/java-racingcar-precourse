package domain.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public List<Car> makeCars(List<String> carNames){
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
