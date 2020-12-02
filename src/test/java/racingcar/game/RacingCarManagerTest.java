package racingcar.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarManagerTest {

    @Test
    void 생성자_예외() {
        // given
        final String exceedLenStr = "abcdefg";
        List<String> exceedLenStrGettedList = new ArrayList<>();

        // when
        exceedLenStrGettedList.add(exceedLenStr);

        // then
        assertThrows(IllegalArgumentException.class, () -> new RacingCarManager(exceedLenStrGettedList));
    }

    @Test
    void 생성자_성공_원소_길이_검증() {
        // given
        final String nonExceedLenStr = "abcde";
        final String nonExceedLenSecondStr = "bcd";
        List<String> nonExceedLenStrGettedList = new ArrayList<>();

        // when
        nonExceedLenStrGettedList.add(nonExceedLenStr);
        nonExceedLenStrGettedList.add(nonExceedLenSecondStr);
        RacingCarManager racingCarManager = new RacingCarManager(nonExceedLenStrGettedList);

        // then
        assertThat(racingCarManager.numberOfRacingCar() == 2).isTrue();
    }
}