package racingcar.game;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarMovingFlag;
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

    @Test
    void 두_명_플레이어_게임_시도_1_1_출력_문자열_검증() {
        // given
        final String expectedPobiStrResult = "pobi : -";
        final String expectedKkhStrResult = "kkh : -";
        List<String> expectedResultList = Arrays.asList(expectedPobiStrResult, expectedKkhStrResult);
        List<String> strNameList = Arrays.asList("pobi", "kkh");
        RacingCarManager racingCarManager = new RacingCarManager(strNameList);
        List<CarMovingFlag> twoForwardFlag = new ArrayList<>(strNameList.size());
        twoForwardFlag.add(CarMovingFlag.FORWARD);
        twoForwardFlag.add(CarMovingFlag.FORWARD);

        // when
        racingCarManager.updateRacingCarPosition(twoForwardFlag);

        // then
        assertThat(racingCarManager.nowPositionResultStrList()).isEqualTo(expectedResultList);
    }

    @Test
    void 두_명_플레이어_게임_시도_0_1_출력_문자열_검증() {
        // given
        final String expectedPobiStrResult = "pobi : ";
        final String expectedKkhStrResult = "kkh : -";
        List<String> expectedResultList = Arrays.asList(expectedPobiStrResult, expectedKkhStrResult);
        List<String> strNameList = Arrays.asList("pobi", "kkh");
        RacingCarManager racingCarManager = new RacingCarManager(strNameList);
        List<CarMovingFlag> oneStopOneForwardFlag = new ArrayList<>(strNameList.size());
        oneStopOneForwardFlag.add(CarMovingFlag.STOP);
        oneStopOneForwardFlag.add(CarMovingFlag.FORWARD);

        // when
        racingCarManager.updateRacingCarPosition(oneStopOneForwardFlag);

        // then
        assertThat(racingCarManager.nowPositionResultStrList()).isEqualTo(expectedResultList);
    }

    @Test
    void 두_명_플레이어_게임_시도_0_0_출력_문자열_검증() {
        // given
        final String expectedPobiStrResult = "pobi : ";
        final String expectedKkhStrResult = "kkh : ";
        List<String> expectedResultList = Arrays.asList(expectedPobiStrResult, expectedKkhStrResult);
        List<String> strNameList = Arrays.asList("pobi", "kkh");
        RacingCarManager racingCarManager = new RacingCarManager(strNameList);
        List<CarMovingFlag> allStopFlag = new ArrayList<>(strNameList.size());
        allStopFlag.add(CarMovingFlag.STOP);
        allStopFlag.add(CarMovingFlag.STOP);

        // when
        racingCarManager.updateRacingCarPosition(allStopFlag);

        // then
        assertThat(racingCarManager.nowPositionResultStrList()).isEqualTo(expectedResultList);
    }
}