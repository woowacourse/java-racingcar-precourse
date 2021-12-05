package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Objects;

public class PlayTime {

	public static final String PLAY_TIME_NOT_NUMBER_EXCEPTION = "[ERROR] 시도 횟수는 숫자여야 한다.";
	public static final String PLAY_TIME_NON_POSITIVE_EXCEPTION = "[ERROR] 시도 횟수는 양수이어야 한다.";
	private Integer round = 0;

	public void getInput() {
		try {
			String input = readLine();
			validInput(input);
			round = Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			getInput();
		}
	}

	private void validInput(String input) {
		validInteger(input);
		validPositive(input);
	}

	private void validInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println(PLAY_TIME_NOT_NUMBER_EXCEPTION);
			throw new IllegalArgumentException();
		}
	}

	private void validPositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			System.out.println(PLAY_TIME_NON_POSITIVE_EXCEPTION);
			throw new IllegalArgumentException();
		}
	}

	public boolean isSame(PlayTime playTime) {
		return this.equals(playTime);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayTime playTime = (PlayTime)o;
		return Objects.equals(round, playTime.round);
	}

	@Override
	public int hashCode() {
		return Objects.hash(round);
	}

	public void increase() {
		round += 1;
	}
}
