package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    public static final String ERROR_PREFIX = "[ERROR]";

    Car car = new Car("붕붕이");

    @Test
    void Car_객체의_이름은_생성자의_인자로_결정된다() {
        assertThat(car.getName()).isEqualTo("붕붕이");
    }

    @Test
    void Car_객체의_이름은_앞_뒤_공백을_제거한_값이다() {
        Car testCar = new Car(" 방방이 ");
        assertThat(testCar.getName()).isEqualTo("방방이");
    }

    @Test
    void Car_객체의_이름이_5자_이하가_아니면_예외() {
        assertThatThrownBy(() -> {
            new Car("over_5_length");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @Test
    void Car_객체의_이름이_빈값이거나_NULL이면_예외() {
        assertThatThrownBy(() -> {
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
        assertThat(car.getPosition())
                .isEqualTo(position + 1);
    }

    @Nested
    class equals_메소드는_Car의_이름을_비교한다 {
        Car sameCar = new Car("붕붕이");
        Car differenceCar = new Car("페라리");
        String stringCar = "붕붕이";

        @Test
        void 다른_형식의_객체가_들어오면_False() {
            assertThat(car.equals(stringCar)).isFalse();
        }

        @Test
        void 같은_이름을_가진_Car객체가_들어오면_True() {
            assertThat(car.equals(sameCar)).isTrue();
        }

        @Test
        void 다른_이름을_가진_Car객체가_들어오면_False() {
            assertThat(car.equals(differenceCar)).isFalse();
        }

    }
}