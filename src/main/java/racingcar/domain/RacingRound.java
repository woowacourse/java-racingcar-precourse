package racingcar.domain;

import racingcar.enums.DomainConditions;

public class RacingRound {
	private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 입력 형식이 잘못되었습니다.";
	private static final String ZERO_ERROR_MESSAGE = "[ERROR] 1이상의 수를 입력해주세요.";
	private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 음수는 입력할 수 없습니다.";

	private static final int EMPTY_RACING_ROUND = DomainConditions.EMPTY_RACING_ROUND.get();

	private final int racingRound;

	public RacingRound(String racingRound) {
		validateNumberFormat(racingRound);
		int parseInt = Integer.parseInt(racingRound);
		validateRange(parseInt);
		this.racingRound = parseInt;
	}

	public int get() {
		return racingRound;
	}

	private void validateNumberFormat(String racingRound) {
		try {
			Integer.parseInt(racingRound);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}

	private void validateRange(int parseInt) {
		if (parseInt == EMPTY_RACING_ROUND) {
			throw new IllegalArgumentException(ZERO_ERROR_MESSAGE);
		}
		if (parseInt < EMPTY_RACING_ROUND) {
			throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
		}
	}
}
