package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름들의 문자열에서 리스트 생성 테스트")
    public void setUpCars_carNames_returnSameName() {

        // given
        String carNames = "equus, lexus, SM5, K7";

        // when
        RacingCars racingCars = new RacingCars(carNames);

        // then
        String expectedCarNames = "[equus, lexus, SM5, K7]";

        String carNameListString = racingCars.getRacingCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList())
                .toString();

        assertThat(carNameListString).isEqualTo(expectedCarNames);
    }

    @Test
    @DisplayName("자동차 리스트가 불변 리스트인지 테스트")
    public void add_NewCar_ExceptionThrown() {

        // given
        String carNames = "equus, lexus, SM5, K7";
        RacingCars racingCars = new RacingCars(carNames);

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> racingCars.getRacingCars().add(new Car("tico"));

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(UnsupportedOperationException.class)
                .hasMessage(null);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    public void moveCars_RacingCars_returnMovedPosition() {

        // given
        List<Car> cars = Arrays.asList(
                new Car("equus", 5),
                new Car("SM5", 4),
                new Car("tico", 3)
        );

        // when
        RacingCars racingCars = new RacingCars(cars).moveCars();

        // then
        List<Integer> positions = racingCars.getRacingCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions).containsExactly(1, 1, 0);
    }

    @Test
    @DisplayName("우승자가 1명일 경우 우승자 반환 테스트")
    public void findWinners_OneWinner_ReturnWinner() {

        // given
        List<Car> cars = Arrays.asList(
                new Car("equus", 9),
                new Car("SM5", 3),
                new Car("tico", 3)
        );


        // when
        RacingCars racingCars = new RacingCars(cars).moveCars();

        //then
        assertThat(racingCars.findWinners()).containsExactly("equus");
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 우승자 반환 테스트")
    public void findWinners_ManyWinners_ReturnWinners() {

        // given
        List<Car> cars = Arrays.asList(
                new Car("equus", 9),
                new Car("SM5", 5),
                new Car("K7", 7),
                new Car("tico", 3)
        );

        // when
        RacingCars racingCars = new RacingCars(cars).moveCars();

        //then
        assertThat(racingCars.findWinners()).containsExactly("equus", "SM5", "K7");
    }
}
