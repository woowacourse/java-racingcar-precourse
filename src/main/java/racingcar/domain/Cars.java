package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars generate(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private void validate(List<Car> cars) {
        validateCarNames(cars);
        validateEmpty(cars);
    }

    private void validateCarNames(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        validateDuplicatedName(carNames);
    }

    private void validateDuplicatedName(List<String> carNames) {
        Set<String> nonDuplicatedNames = new HashSet<>(carNames);
        if (nonDuplicatedNames.size() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 한 대 이상의 자동차 이름을 입력해야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
