package racingcar.view.input;

import java.math.BigInteger;
import java.util.regex.Pattern;

import racingcar.client.ErrorClient;
import racingcar.client.InputClient;
import racingcar.domain.round.RacingRound;

public class InputCountView {
	private static final String PROMPT = "시도할 회수는 몇회인가요?";

	private static final Pattern PATTERN = Pattern.compile("^[1-9]+\\d*");
	private static final String ERR_NON_POSITIVE_INTEGER = "입력값이 정수형의 양수가 아닙니다.";

	private static final BigInteger MAX = BigInteger.valueOf(Integer.MAX_VALUE);
	private static final String ERR_INTEGER_OVERFLOW = "입력값이 너무 큽니다. 2^31 미만으로 입력하세요.";

	private final InputClient inputClient;
	private final ErrorClient errorClient;

	public InputCountView(InputClient inputClient, ErrorClient errorClient) {
		this.inputClient = inputClient;
		this.errorClient = errorClient;
	}

	public RacingRound inputCount() {
		try {
			return tryInputCount();
		} catch (IllegalArgumentException exception) {
			errorClient.error(exception.getMessage());
			return inputCount();
		}
	}

	private RacingRound tryInputCount() throws IllegalArgumentException {
		return new RacingRound(parseInt(inputClient.input(PROMPT)));
	}

	private int parseInt(String input) {
		validateInputString(input);
		return Integer.parseInt(input);
	}

	private void validateInputString(String input) {
		validatePositiveInteger(input);
		validateIntegerOverflow(input);
	}

	private void validatePositiveInteger(String input) {
		if (!PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(ERR_NON_POSITIVE_INTEGER);
		}
	}

	private void validateIntegerOverflow(String input) {
		if (new BigInteger(input).compareTo(MAX) > 0) {
			throw new IllegalArgumentException(ERR_INTEGER_OVERFLOW);
		}
	}
}
