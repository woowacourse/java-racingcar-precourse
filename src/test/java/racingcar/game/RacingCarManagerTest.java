package racingcar.game;

import org.junit.jupiter.api.Test;
import utils.CarMovingFlagUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    void 첫_번째_위치_최종_승리자_거리_검증() {
        // given
        final int stopFlagNumber = 1;
        final int forwardFlagNumber = 5;

        List<Integer> flagNumberList = new ArrayList<>();
        flagNumberList.add(forwardFlagNumber); //foward
        flagNumberList.add(stopFlagNumber); // stop

        List<String> nameList = new ArrayList<>(2);
        nameList.add("kkh");
        nameList.add("pobi");

        // when
        RacingCarManager racingCarManager = new RacingCarManager(nameList);
        racingCarManager.updateRacingCarPosition(CarMovingFlagUtils.makeCarMovieFlagList(flagNumberList));

        // then
        assertThat(racingCarManager.getNowWinnerPlayersName()).isEqualTo(Collections.singletonList("kkh"));
    }

    @Test
    void 두_번째_위치_최종_승리자_거리_검증() {
        // given
        final int stopFlagNumber = 1;
        final int forwardFlagNumber = 5;

        List<Integer> flagNumberList = new ArrayList<>();
        flagNumberList.add(stopFlagNumber); // stop
        flagNumberList.add(forwardFlagNumber); //foward

        List<String> nameList = new ArrayList<>(2);
        nameList.add("kkh");
        nameList.add("pobi");

        // when
        RacingCarManager racingCarManager = new RacingCarManager(nameList);
        racingCarManager.updateRacingCarPosition(CarMovingFlagUtils.makeCarMovieFlagList(flagNumberList));

        // then
        assertThat(racingCarManager.getNowWinnerPlayersName()).isEqualTo(Collections.singletonList("pobi"));
    }

    @Test
    void 두_명의_최종_승리자_거리_검증() {
        // given
        final int forwardFlagNumber = 5;

        List<Integer> flagNumberList = new ArrayList<>();
        flagNumberList.add(forwardFlagNumber); // forward
        flagNumberList.add(forwardFlagNumber); //foward

        List<String> nameList = new ArrayList<>(2);
        nameList.add("kkh");
        nameList.add("pobi");

        // when
        RacingCarManager racingCarManager = new RacingCarManager(nameList);
        racingCarManager.updateRacingCarPosition(CarMovingFlagUtils.makeCarMovieFlagList(flagNumberList));

        // then
        List<String> resultWinnerList = racingCarManager.getNowWinnerPlayersName();
        Collections.sort(resultWinnerList);
        List<String> expectedWinnerList = Arrays.asList("kkh", "pobi");
        Collections.sort(expectedWinnerList);
        assertThat(resultWinnerList).isEqualTo(expectedWinnerList);
    }
}