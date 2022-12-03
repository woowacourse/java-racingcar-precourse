package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.NumberGenerator;

class PlayerTest {

    static Player player;

    @BeforeAll
    static void init() {
        List<String> playerNames = Arrays.asList("pobi", "conan", "crong");
        player = new Player(playerNames);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "8,2", "2,2", "7,3"})
    void 올바르게_전진_확인(int number, int position) {
        NumberGenerator numberGenerator = new TestNumberGenerator(number);
        player.playOneRound(numberGenerator);
        List<Car> racingCars = player.getRacingCars();
        for (Car car : racingCars) {
            assertThat(car.getPosition()).isEqualTo(position);
        }
    }

    class TestNumberGenerator implements NumberGenerator {

        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generate() {
            return number;
        }
    }
}