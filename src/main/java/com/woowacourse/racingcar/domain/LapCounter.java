package com.woowacourse.racingcar.domain;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class LapCounter {
    private static final String EXCEPTION_ALREADY_END_LAP = "모든 랩을 돌아 더 이상 돌 수 없습니다.";
    private static final String EXCEPTION_INVALID_TOTAL_LAP = "한 바퀴 이상 돌아야 합니다.";
    private final static int START_LAP_COUNT = 0;

    private final int totalLap;
    private int currentLap = START_LAP_COUNT;

    public LapCounter(int totalLap) {
        validateTotalLap(totalLap);
        this.totalLap = totalLap;
    }

    private void validateTotalLap(int totalLap) {
        if (totalLap <= START_LAP_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_TOTAL_LAP);
        }
    }

    public void nextLap() {
        if (isEndOfLap()) {
            throw new IndexOutOfBoundsException(EXCEPTION_ALREADY_END_LAP);
        }
        ++currentLap;
    }

    public boolean isEndOfLap() {
        return currentLap == totalLap;
    }
}
