package model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.movement.Movement;
import model.movement.RandomMovement;

class CarsTest {
    private final boolean[] movement = new boolean[] {true, false, true};
    private int movementIndex = 0;
    private final Movement randomMovement = new RandomMovement() {
        @Override
        public boolean canMove() {
            return movement[movementIndex++];
        }
    };
    private final List<String> carNames = Arrays.asList("Chris", "Henry", "Paul");
    private final Cars cars = new Cars(carNames);

    @BeforeEach
    void setUp() {
        cars.race(randomMovement);
    }

    @Test
    @DisplayName("자동차들을 전진시키고 결과를 반환한다.")
    void race_getRacingResult() {
        List<Car> carsAfterRacing = cars.getAttemptResult();
        assertAll(
                () -> assertThat(carsAfterRacing.get(0).getName()).isEqualTo("Chris"),
                () -> assertThat(carsAfterRacing.get(1).getName()).isEqualTo("Henry"),
                () -> assertThat(carsAfterRacing.get(2).getName()).isEqualTo("Paul"),
                () -> assertThat(carsAfterRacing.get(0).getPosition()).isEqualTo(1),
                () -> assertThat(carsAfterRacing.get(1).getPosition()).isEqualTo(0),
                () -> assertThat(carsAfterRacing.get(2).getPosition()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("위치 값이 가장 큰 자동차(들)을 반환한다.")
    void getWinners() {
        List<Car> winners = cars.getWinners();
        assertAll(
                () -> assertThat(winners.size()).isEqualTo(2),
                () -> assertThat(winners.get(0).getName()).isEqualTo("Chris"),
                () -> assertThat(winners.get(1).getName()).isEqualTo("Paul")
        );
    }

    @Test
    @DisplayName("자동차들의 이름들 간에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedNames() {
        List<String> overlappedNames = Arrays.asList("Chris", "Chris", "Henry");
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(overlappedNames))
                .withMessage("이름들 간에 중복이 있습니다.");
    }
}
