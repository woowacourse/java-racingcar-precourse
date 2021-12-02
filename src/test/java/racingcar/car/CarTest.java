package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("이름의 길이가 5이하인 경우 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void constructor_nameLessThen5_create(String name) {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        //  when & then
        assertThatCode(() -> {
            new Car(name, randomMovingPolicy);
        }).doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 5초과인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "woniii", "junnnn"})
    void constructor_nameMoreThen5_ExceptionThrown(String name) {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        //  when & then
        assertThatThrownBy(() -> {
            new Car(name, randomMovingPolicy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("movingPolicy의 isMoving이 true이면 position이 1 증가한다.")
    @Test
    void move_isMovingThenTrue_increasePosition() {
        // given
        MovingPolicy movingPolicy = () -> true;
        Car car = new Car("pobi", movingPolicy);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("movingPolicy의 isMoving이 false이면 position은 정지한다.")
    @Test
    void move_isMovingThenFalse_stopPosition() {
        // given
        MovingPolicy movingPolicy = () -> false;
        Car car = new Car("pobi", movingPolicy);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}