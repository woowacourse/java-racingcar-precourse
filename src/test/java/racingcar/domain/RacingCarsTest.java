package racingcar.domain;

import java.util.stream.Collectors;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    public void initRacingCars() {
        String carNames = "equus, lexus, SM5, K7";

        racingCars = new RacingCars(carNames);
    }

    @Test
    @DisplayName("자동차 이름들의 문자열에서 리스트 생성 테스트")
    public void setUpCars_carNames_returnSameName() {

        // given
        String expectedCarNames = "[equus, lexus, SM5, K7]";

        // when
        String carNameListString = racingCars.getRacingCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList())
                .toString();

        // then
        assertThat(carNameListString).isEqualTo(expectedCarNames);
    }

    @Test
    @DisplayName("자동차 리스트가 불변 리스트인지 테스트")
    public void add_NewCar_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> racingCars.getRacingCars().add(new Car("tico"));

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(UnsupportedOperationException.class)
                .hasMessage(null);
    }
}