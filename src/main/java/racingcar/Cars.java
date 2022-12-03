package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;
    Coin coin;

    public Cars(List<Car> cars, Coin coin) {
        this.cars = cars;
        this.coin = coin;
    }

    public void move() {
        while (coin.use()) {
            cars.stream().forEach(c -> c.move());
        }
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
