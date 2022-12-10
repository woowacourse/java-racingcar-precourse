package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    public static final String ERROR_PREFIX = "[ERROR]";

    Car car = new Car("붕붕이");

    @Test
    void Car_객체의_이름은_생성자의_인자로_결정된다() {
        Assertions.assertThat(car.getName()).isEqualTo("붕붕이");
    }

    @Test
    void Car_객체의_이름이_5자_이하가_아니면_예외() {
        Assertions.assertThatThrownBy(() -> {
                    new Car("over_5_length");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @Test
    void Car_객체의_이름이_빈값이거나_NULL이면_예외() {
        Assertions.assertThatThrownBy(() -> {
                    new Car("");
                    new Car(null);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @Test
    void move_메소드는_자동차가_이동하고난_뒤의_위치를_반환한다() {
        //given
        int position = car.getPosition();

        //when
        car.move();

        //then
        Assertions.assertThat(car.getPosition())
                .isEqualTo(position + 1);
    }
}