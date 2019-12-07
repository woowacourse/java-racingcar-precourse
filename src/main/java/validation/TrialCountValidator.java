package validation;

public class TrialCountValidator implements Validator<Integer> {
	private static final int MIN_COUNT = 1;

	@Override
	public void validate(Integer count) {
		if (count < MIN_COUNT) {
			throw new IllegalArgumentException("시도할 횟수가 " + MIN_COUNT + " 미만입니다.");
		}
	}
}
