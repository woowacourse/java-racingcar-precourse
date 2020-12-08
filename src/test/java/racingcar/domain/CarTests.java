package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTests {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "abcde", "1 3 5"})
    public void 객체생성_성공(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"longname", ""})
    public void 객체생성_실패_예외발생(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(carName));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    public void 자동차_전진_성공(int forwardCount) {
        Car car = new Car("test");

        for (int i = 0; i < forwardCount; i++) {
            car.forwardOneStep();
        }

        assertThat(car.getPosition())
                .isEqualTo(forwardCount);
    }
}
