package racingcar.domain.race;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.race.exception.CarNameLongerThanMaximumException.MAXIMUM_SIZE_OF_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.race.exception.CarNameLongerThanMaximumException;
import racingcar.domain.race.exception.EmptyCarNameInputException;

@DisplayName("RaceSetting에 대한 테스트")
class RaceSettingTest {

    @DisplayName("입력받은 자동차 이름들에 빈 값이 있을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", ",", " ,", ", ", " ,a", "  , a"})
    void emptyCarName(String value) {
        final int movingCount = 3;

        assertThrows(EmptyCarNameInputException.class, () ->
            RaceSetting.makeRace(value, movingCount));
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
                RaceSetting.makeRace(name.toString(), movingCount));
    }
}