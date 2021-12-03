package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

        assertThat(racingGame.createCars(input)).isEqualTo(cars);
    }

    @Test
    void 입력값으로_경기_회차를_설정() {
        int input = 10;
        assertThat(racingGame.createRoundNumber(input)).isEqualTo(input);
    }
}
