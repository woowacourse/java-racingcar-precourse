package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.CarNameLengthException;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarTest {

    @DisplayName("Car 생성 성공 : 이름 문자열의 길이가 1~5인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "a", "b1"})
    public void Car_유효한_이름_문자열_객체_생성_성공한다(String name) {
        assertThatCode(() -> {
            new Car(name, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("Car 생성 예외 : 이름 문자열이 공백이거나, 빈 문자열이거나, null인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  \t", " "})
    public void Car_유효하지_않은_이름_문자열_예외_발생한다(String name) {
        assertThatCode(() -> {
            new Car(name, new RandomMovingStrategy());
        }).isInstanceOf(CarNameLengthException.class);
    }

    @DisplayName("Car의 기본 position 값은 0")
    @Test
    public void position_기본값은_0이다() {
        Car car = new Car("crong", new RandomMovingStrategy());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car 이동하면 position이 1만큼 증가 : 항상 움직이는 전략을 가진 경우")
    @Test
    public void move_항상_움직이는_전략_position이_1만큼_증가한다() {
        MovingStrategy alwaysMovingStrategy = () -> true;
        Car car = new Car("crong", alwaysMovingStrategy);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("Car 이동하지 않으면 position은 변함 없음 : 항상 움직이지 않는 전략을 가진 경우")
    @Test
    public void move_항상_움직이지_않는_전략_position이_변하지_않는다() {
        MovingStrategy neverMovingStrategy = () -> false;
        Car car = new Car("crong", neverMovingStrategy);

        car.move();

        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("Car 객체 2개의 위치가 같으면 비교 true 반환")
    @Test
    public void isSamePosition_위치가_같으면_true를_반환한다() {
        Car car = new Car("test1", () -> true);
        Car targetCar = new Car("test2", () -> false);

        boolean isSamePosition = car.isSamePosition(targetCar);

        assertThat(isSamePosition).isTrue();
    }

    @DisplayName("Car 객체 2개의 위치가 다르면 비교 false 반환")
    @Test
    public void isSamePosition_위치가_다르면_false를_반환한다() {
        Car car = new Car("test1", () -> true);
        Car targetCar = new Car("test2", () -> false);

        car.move();
        boolean isSamePosition = car.isSamePosition(targetCar);

        assertThat(isSamePosition).isFalse();
    }
}
