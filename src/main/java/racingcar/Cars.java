package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(CarNames carNames) {
        while (carNames.hasNext()) {
            cars.add(
                    new Car(
                            carNames.next(),
                            new RandomNumberGenerator()));
        }
    }

    public String move() {
        return cars.stream()
                .map(c -> c.move())
                .collect(Collectors.joining());
    }

    public String findWinners() {
        int max = findMax();
        return cars.stream().filter(c -> c.getPosition() == max)
                .map(c -> c.getName())
                .collect(Collectors.joining(", "));
    }

    private int findMax() {
        return cars.stream().mapToInt(c -> c.getPosition()).max()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 자동차 위치가 발견되었습니다"));
    }
}
