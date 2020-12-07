package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        carList.addAll(Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }
}
