package racingcar.domain.race;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.race.exception.AlreadyCompleteException;

@DisplayName("Race에 대한 테스트")
class RaceTest {

    @DisplayName("모든 자동차들을 움직인다.")
    @Test
    void move() {
        final String carNamesStr = "a,b,c";
        final int movingCount = 3;
        Race race = RaceSetting.makeRace(carNamesStr, movingCount, value -> true);

        race.move();

        boolean isAllCarIsMoved = race.getCars().stream()
            .allMatch(car -> car.getPosition() == Car.DEFAULT_POSITION + 1);
        assertTrue(isAllCarIsMoved);
    }

    @DisplayName("이미 완료된 경기는 자동차를 움직일 수 없다.")
    @Test
    void alreadyCompleteRace() {
        final String name = "a,b,c";
        final int movingCount = 3;
        Race race = RaceSetting.makeRace(name, movingCount);
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