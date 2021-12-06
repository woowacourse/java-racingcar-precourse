package racingcar.domain.trycounter;

public class LabMustBeNumberException extends IllegalArgumentException {

	private static final String TRY_COUNT_MUST_BE_NUMERIC = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public LabMustBeNumberException() {
		super(TRY_COUNT_MUST_BE_NUMERIC);
	}
}
