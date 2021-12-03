package racingcar;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private final RacingGame racingGame = new RacingGame();

    @Test
    void 입력값으로_차를_생성() {
        String[] input = new String[]{"pobi", "woni", "jun"};
        List<Car> cars = new ArrayList<>();
        cars.add(Car.create("pobi"));
        cars.add(Car.create("woni"));
        cars.add(Car.create("jun"));
        Assertions.assertThat(racingGame.createCars(input)).isEqualTo(cars);
    }
}
