package racingcar.domain.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @DisplayName("RacingGame 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "carA,carB:2", "carA,carB,carC:1"
    }, delimiter = ':')
    void testInitRacingGame(String carNames, int tryNumberValue) {
        //given
        TryNumber tryNumber = new TryNumber(tryNumberValue);
        Cars cars = new Cars(Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

        //when
        RacingGame racingGame = new RacingGame(cars, tryNumber);

        //then
        assertAll(
                () -> assertThat(racingGame).extracting("cars").isEqualTo(cars),
                () -> assertThat(racingGame).extracting("tryNumber").isEqualTo(tryNumber)
        );
    }
}
