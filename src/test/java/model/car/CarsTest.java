package model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.movement.RandomMovement;

class CarsTest {
    private final boolean[] movement = new boolean[] {true, false, true};
    private int movementIndex = 0;
    private final RandomMovement randomMovement = new RandomMovement() {
        @Override
        public boolean canMove() {
            return movement[movementIndex++];
        }
    };

    @Test
    @DisplayName("자동차들을 전진시키고 결과를 반환한다.")
    void race_getRacingResult() {
        List<String> carNames = Arrays.asList("Chris", "Henry", "Paul");
        Cars cars = new Cars(carNames);
        cars.race(randomMovement);
        List<Car> carsAfterRacing = cars.getRacingResult();
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
    @DisplayName("자동차들의 이름들 간에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedNames() {
        List<String> overlappedNames = Arrays.asList("Chris", "Chris", "Henry");
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(overlappedNames))
                .withMessage("이름들 간에 중복이 있습니다.");
    }
}
