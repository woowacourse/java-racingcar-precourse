package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("Car 생성시")
    @Nested
    class CreateCar {

        @DisplayName("이름이 빈문자열이면 예외를 반환한다.")
        @Test
        public void carNameIsEmpty() {
            assertThatIllegalArgumentException().isThrownBy(() -> new Car(""));
        }

        @DisplayName("이름에 공백이 포함되면 예외를 반환한다.")
        @Test
        public void carNameContainBlank() {
            assertThatIllegalArgumentException().isThrownBy(() -> new Car(" 1"));
        }


        @DisplayName("이름 길이가 5글자 초과면 예외를 반환한다.")
        @Test
        public void carCreateException() {
            assertThatIllegalArgumentException().isThrownBy(() -> new Car("asddgf"));
        }

        @DisplayName("이름이 문제가 없으면 정상적으로 생성한다")
        @Test
        public void carCreateOk() {
            assertThatNoException().isThrownBy(() -> new Car("pobi"));
        }
    }

    @DisplayName("자동차가 이동시 입력받은 값이")
    @Nested
    class Move {

        @DisplayName("4 이상 이면 한칸 이동한다.")
        @Test
        void moveSuccessTest() {
            Car car = new Car("test");
            car.move(4);
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @DisplayName("4 미만 이면 이동하지 않는다..")
        @Test
        void moveFalseTest() {
            Car car = new Car("test");
            car.move(3);
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}