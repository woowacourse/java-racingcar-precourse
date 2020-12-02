package racingcar.domain.race;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.race.exception.CarNameLongerThanMaximumException.MAXIMUM_SIZE_OF_CAR_NAME;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.race.exception.AlreadyCompleteException;
import racingcar.domain.race.exception.CarNameLongerThanMaximumException;
import racingcar.domain.race.exception.EmptyCarNameInputException;

@DisplayName("Race에 대한 테스트")
class RaceTest {

    @DisplayName("입력받은 자동차 이름들에 빈 값이 있을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", ",", " ,", ", ", " ,a", "  , a"})
    void emptyCarName(String value) {
        final int movingCount = 3;

        assertThrows(EmptyCarNameInputException.class, () ->
            Race.of(value, movingCount));
    }

    @DisplayName("입력받은 자동차 이름들의 길이는 5를 넘어갈 수 없다.")
    @Test
    void longerThanMaximumCarName() {
        StringBuilder name = new StringBuilder();
        final int overCount = MAXIMUM_SIZE_OF_CAR_NAME + 1;
        for (int i = 0; i < overCount; i++) {
            name.append("a");
        }
        final int movingCount = 3;

        assertThrows(
            CarNameLongerThanMaximumException.class, () ->
                Race.of(name.toString(), movingCount));
    }

    @DisplayName("모든 자동차들을 움직인다.")
    @Test
    void move() {
        final List<String> carNames = Arrays.asList("a", "b", "c");
        final int movingCount = 3;
        Race race = Race.of(carNames, movingCount, value -> true);

        race.move();

        boolean isAllCarIsMoved = race.getCars().stream()
            .allMatch(car -> car.getPosition() == Car.DEFAULT_POSITION + 1);
        assertTrue(isAllCarIsMoved);
    }

    @DisplayName("이미 완료된 경기는 자동차를 움직일 수 없다.")
    @Test
    void alreadyCompleteRace() {
        final String name = "test";
        final int movingCount = 3;
        Race race = Race.of(name, movingCount);
        final int overCount = movingCount + 1;

        assertThrows(AlreadyCompleteException.class, () -> {
            for (int i = 0; i < overCount; i++) {
                race.move();
            }
        });
    }

    @DisplayName("가장 선두에 있는 자동차들을 확인한다.")
    @Test
    void confirmFirstPlaceCars() {
        Car car1 = Car.of("car1", value -> true);
        Car car2 = Car.of("car2", value -> true);
        Car car3 = Car.of("car3", value -> false);
        final int movingCount = 1;
        Race race = Race.of(Arrays.asList(car1, car2, car3), movingCount);

        race.move();

        List<Car> cars = race.getFirstPlaceCars();
        assertTrue(cars.contains(car1));
        assertTrue(cars.contains(car2));
        assertFalse(cars.contains(car3));
    }
}