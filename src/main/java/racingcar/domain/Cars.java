package racingcar.domain;

import racingcar.validator.CarNameValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validate(carNames);
        cars = carNames.stream()
                .map(CarNameValidator::validate)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> carNames) {
        validateDuplicatedName(carNames);
        validateEmpty(carNames);
    }

    private void validateDuplicatedName(List<String> carNames) {
        Set<String> nonDuplicatedNames = new HashSet<>(carNames);
        if (nonDuplicatedNames.size() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    private void validateEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력된 이름이 없습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
