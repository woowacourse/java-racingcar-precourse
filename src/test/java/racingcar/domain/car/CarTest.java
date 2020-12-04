package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.CarNameLengthException;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarTest {

    @DisplayName("Car 생성 성공 : 이름 문자열의 길이가 1~5인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "a", "b1"})
    public void Car_유효한_이름_문자열_객체_생성_성공한다(String name) {
        assertThatCode(() -> {
            new Car(name);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Car 생성 예외 : 이름 문자열이 공백이거나, 빈 문자열이거나, null인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  \t", " "})
    public void Car_유효하지_않은_이름_문자열_예외_발생한다(String name) {
        assertThatCode(() -> {
            new Car(name);
        }).isInstanceOf(CarNameLengthException.class);
    }
}
