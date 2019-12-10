package com.woowacourse.racingcar;

import com.woowacourse.racingcar.controller.RacingGame;
import com.woowacourse.racingcar.domain.LapCounter;
import com.woowacourse.racingcar.domain.RacingTrack;
import com.woowacourse.racingcar.domain.RandomPowerGenerator;
import com.woowacourse.racingcar.view.InputView;

import java.util.List;
import java.util.Random;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        RacingTrack racingTrack = getRacingTrack();
        LapCounter lapCounter = getLapCounter();
        RacingGame racingGame = new RacingGame(racingTrack, lapCounter);
        racingGame.run();
    }

    public static RacingTrack getRacingTrack() {
        try {
            List<String> carNames = InputView.getCarNames();
            RandomPowerGenerator randomPowerGenerator = new RandomPowerGenerator(new Random());
            return RacingTrack.createRacingTrack(carNames, randomPowerGenerator);
        } catch (IllegalArgumentException e) {
            return getRacingTrack();
        }
    }

    public static LapCounter getLapCounter() {
        try {
            int totalLap = InputView.getTotalLaps();
            return new LapCounter(totalLap);
        } catch (IllegalArgumentException e) {
            return getLapCounter();
        }
    }
}
