package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("이름이 1자 이상 5자 이하가 아닐 경우 Exception이 발생해야 한다.")
    void createExceptionByLargeNameLengthTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Car.createRandomMoveCar(input))
            .withMessage("[ERROR] Car의 이름은 1자 이상 5자 이하만 입력되어야 합니다.");
    }

    @Test
    @DisplayName("이름은 null이 들어올 경우 Exception이 발생해야 한다.")
    void createExeptionByNullNameTest() {
        // given
        String input = null;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Car.createRandomMoveCar(input))
            .withMessage("[ERROR] Car의 이름은 null이 들어올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "p ob", "pob "})
    @DisplayName("이름에 공백이 포함될 경우 Exception이 발생해야 한다.")
    void createExceptionByBlankNameTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Car.createRandomMoveCar(input))
            .withMessage("[ERROR] Car의 이름은 공백이 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("Car는 움직일 수 있는 경우 한칸 이동한다.")
    void moveTrueTest() {
        // given
        Car car = new Car("pobi", () -> true);

        // when
        int result = car.move();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Car는 움직일 수 없는 경우 그대로 멈춰있는다.")
    void moveNothingTest() {
        // given
        Car car = new Car("pobi", () -> false);

        // when
        int result = car.move();

        // then
        assertThat(result).isEqualTo(0);
    }
}