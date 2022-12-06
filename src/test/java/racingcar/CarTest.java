package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final String EXCEPTION_MESSAGE_CAR_NAME_LENGTH = "[ERROR] 자동차이름은 5글자 이하입니다";

    @DisplayName("Car 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobii", "p", "pob", "3%$^1", "세글자", "k   l"})
    void createCarSuccess(String input) {
        boolean result = true;
        try{
            new Car(input);
        }catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("5글자 초과시 Car 생성시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiid", "dafasdfasdfasdshgsdfg"})
    void createCarByOverLength(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_CAR_NAME_LENGTH);
    }
}
