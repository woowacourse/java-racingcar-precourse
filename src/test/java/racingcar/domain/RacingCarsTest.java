package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    private RacingCars racingCars;

    private List<Car> cars;

    @BeforeEach
    public void initRacingCars() {
        Car equus = new Car("equus", 5);
        Car sm5 = new Car("SM5", 3);
        Car tico = new Car("tico", 3);

        cars = new ArrayList<>(Arrays.asList(equus, sm5, tico));

        racingCars = new RacingCars(cars);
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

    @Test
    @DisplayName("자동차 전진 테스트")
    public void moveCars_RacingCars_returnMovedPosition() {

        // given
        Car equus = new Car("equus", 1, 5);
        Car sm5 = new Car("SM5", 0, 3);
        Car tico = new Car("tico", 0, 3);

        List<Car> expectedCars = Arrays.asList(equus, sm5, tico);

        RacingCars expectedRacingCars = new RacingCars(expectedCars);

        // when
        racingCars = racingCars.moveCars();

        // then
        assertThat(racingCars).isEqualTo(expectedRacingCars);
    }

    @Test
    @DisplayName("우승자가 1명일 경우 우승자 반환 테스트")
    public void findWinners_OneWinner_ReturnWinner() {

        // given
        racingCars = racingCars.moveCars();

        // when
        List<String> winners = racingCars.findWinners();

        //then
        assertThat(winners).containsExactly("equus");
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 우승자 반환 테스트")
    public void findWinners_ManyWinners_ReturnWinners() {

        // given
        cars.add(new Car("K7", 7));

        // when
        RacingCars racingCars = new RacingCars(cars).moveCars();

        //then
        assertThat(racingCars.findWinners()).containsExactly("equus", "K7");
    }
}
