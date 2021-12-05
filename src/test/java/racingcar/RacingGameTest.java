package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.StringConstants.MIN_VALUE_OF_ROUND_NUMBER;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.car.CarRepository;

class RacingGameTest {
    private final RacingGame racingGame = new RacingGame(new CarRepository());

    @Test
    void 입력된_배열에_저장된_순서가_repository의_저장_순서가_된다() {
        String[] carNames = new String[]{"pobi", "woni", "jun"};
        List<Car> savedCars = racingGame.createCars(carNames);
        for (int i = 0; i < savedCars.size(); i++) {
            assertThat(savedCars.get(i).getName()).isEqualTo(carNames[i]);
        }
    }

    @Test
    void 회차가_1보다_작을경우_예외_발생() {
        int smallerInput = 0;
        assertThat(smallerInput).isLessThan(MIN_VALUE_OF_ROUND_NUMBER);
        assertThatThrownBy(() -> racingGame.createNumberOfRounds(smallerInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
