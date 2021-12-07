package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.error.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("이름의 길이가 5이하인 경우 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void constructor_NameLessThen5_Success(String name) {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        //  when & then
        assertThatCode(() -> {
            new Car(name, randomMovingPolicy);
        }).doesNotThrowAnyException();
    }

    @DisplayName("이름이 비어있는 경우 예외를 던진다.")
    @Test
    void constructor_NameThenEmpty_ExceptionThrown() {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        // when & then
        assertThatThrownBy(() -> {
            new Car("", randomMovingPolicy);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_EMPTY.getMessage());
    }

    @DisplayName("이름이 공백인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "    "})
    void constructor_NameThenBlank_ExceptionThrown(String name) {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        // when & then
        assertThatThrownBy(() -> {
            new Car(name, randomMovingPolicy);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_BLANK.getMessage());
    }

    @DisplayName("이름의 길이가 5초과인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "woniii", "junnnn"})
    void constructor_NameMoreThen5_ExceptionThrown(String name) {
        // given
        MovingPolicy randomMovingPolicy = new RandomMovingPolicy();

        //  when & then
        assertThatThrownBy(() -> {
            new Car(name, randomMovingPolicy);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_OVER_LENGTH.getMessage());
    }

    @DisplayName("movingPolicy의 isMoving이 true이면 position이 1 증가한다.")
    @Test
    void move_IsMovingThenTrue_IncreasePosition() {
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
    void move_IsMovingThenFalse_StopPosition() {
        // given
        MovingPolicy movingPolicy = () -> false;
        Car car = new Car("pobi", movingPolicy);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("name과 position을 활용하여 상태 메시지를 생성한다.")
    @Test
    void getStateMessage_NameAndPosition_StateMessageReturn() {
        // given
        MovingPolicy movingPolicy = () -> true;
        Car car = new Car("pobi", movingPolicy);

        // when
        car.move();
        car.move();

        // then
        assertThat(car.getStateMessage()).isEqualTo("pobi : --");
    }
}