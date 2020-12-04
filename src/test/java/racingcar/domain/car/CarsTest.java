package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @DisplayName("Cars의 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitCars() {
        //given
        List<Car> carGroup = Arrays.asList("carA,carB,carC".split(",")).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        //when
        Cars cars = new Cars(carGroup);

        //then
        assertThat(cars).extracting("cars").isEqualTo(carGroup);
    }

    @DisplayName("자동차의 이름이 중복되는 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {
            "car,car", "carA,carA,carB", "a,b,b,c"
    })
    void testInitCarsIfCarNamesAreDuplicated(String carNames) {
        //given
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new Cars(cars))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 자동차들을 전진 or 정지하게하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {
            "carA,carB:false:0", "carA,carB,carC:true:1"
    }, delimiter = ':')
    void testMoveAllForwardOrStop(String carNames, boolean movable, int expectedPosition) {
        //given
        Cars cars = new Cars(Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

        //when
        Cars expectedCars = cars.moveAllForwardOrStop(() -> movable);

        //then
        Assertions.assertThat(expectedCars.getValue())
                .extracting("position")
                .allMatch(position -> position.equals(expectedPosition));
    }
}
