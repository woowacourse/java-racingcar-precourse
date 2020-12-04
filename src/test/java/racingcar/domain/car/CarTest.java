package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.CarNameLengthException;
import racingcar.domain.strategy.RandomMovingStrategy;

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

        asserThat(car.getPosition()).isEqaulTo(0);
    }
}
