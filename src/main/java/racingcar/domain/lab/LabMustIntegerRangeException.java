package racingcar.domain.lab;

public class LabMustIntegerRangeException extends IllegalArgumentException {

	private static final String TRY_COUNT_MUST_INTEGER_RANGE = "[ERROR] 시도 횟수는 INT 범위여야 한다.";

	public LabMustIntegerRangeException() {
		super(TRY_COUNT_MUST_INTEGER_RANGE);
	}
}
