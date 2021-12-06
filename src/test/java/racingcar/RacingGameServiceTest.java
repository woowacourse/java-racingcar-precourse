package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.StringUtils.MIN_VALUE_OF_ROUND_NUMBER;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.car.CarRepository;

class RacingGameServiceTest {
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService(new CarRepository());
    }

    @Test
    void 입력된_배열에_저장된_순서가_repository의_저장_순서가_된다() {
        String[] carNames = new String[]{"pobi", "woni", "jun"};
        List<Car> savedCars = racingGameService.getCarsReady(carNames);
        for (int i = 0; i < savedCars.size(); i++) {
            assertThat(savedCars.get(i).getName()).isEqualTo(carNames[i]);
        }
    }

    @Test
    void 중복된_이름의_자동차가_입력으로_들어올_경우_예외_발생() {
        String[] duplicatedCarNames = {"hi", "hi", "bye"};
        Assertions.assertThatThrownBy(() -> racingGameService.getCarsReady(duplicatedCarNames)).isInstanceOf(IllegalArgumentException.class);
    }
}
