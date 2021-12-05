package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

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
    void 입력값으로_경기_회차를_설정() {
        int input = 10;
        assertThat(racingGame.createNumberOfRounds(input)).isEqualTo(input);
    }
}
