package model.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(final List<String> carNames) {
        validateOverlap(carNames);
        values = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateOverlap(final List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("이름들 간에 중복이 있습니다.");
        }
    }
}
