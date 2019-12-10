package com.woowacourse.racingcar.controller;

import com.woowacourse.racingcar.domain.Car;
import com.woowacourse.racingcar.domain.LapCounter;
import com.woowacourse.racingcar.domain.RacingTrack;
import com.woowacourse.racingcar.domain.Winner;
import com.woowacourse.racingcar.view.OutputView;

import java.util.List;
import java.util.Objects;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class RacingGame {
    private final RacingTrack racingTrack;
    private final LapCounter lapCounter;

    public RacingGame(RacingTrack racingTrack, LapCounter lapCounter) {
        this.racingTrack = Objects.requireNonNull(racingTrack);
        this.lapCounter = Objects.requireNonNull(lapCounter);
    }

    public void run() {
        OutputView.showRunResultMessage();
        race();
        showWinners();
    }

    private void race() {
        while (!lapCounter.isEndOfLap()) {
            racingTrack.moveCars();
            List<Car> cars = racingTrack.getCars();
            OutputView.showRacingStatus(cars);
            lapCounter.nextLap();
        }
    }

    private void showWinners() {
        Winner winner = racingTrack.getRacingResult();
        List<String> winnerNames = winner.getWinnerNames();
        OutputView.showRacingResult(winnerNames);
    }
}
