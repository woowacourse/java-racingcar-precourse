package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        List<String> nameList = new ArrayList(Arrays.asList(names));
        this.cars = nameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
