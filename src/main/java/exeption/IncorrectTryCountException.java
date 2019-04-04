package exeption;

import domain.Track;

/**
 * @author delf
 */
public class IncorrectTryCountException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return String.format("시도 횟수가 너무 적거나 많습니다.(%d번 이상 %d번 이하)", Track.MIN_TRY_COUNT, Track.MAX_TRY_COUNT);
    }
}
