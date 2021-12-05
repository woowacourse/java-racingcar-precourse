package racingcar;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class PlayTime {
	private Integer round = 0;

	public void getInput() {
		String input = Console.readLine();
		validInput(input);
		round = Integer.parseInt(input);
	}

	private void validInput(String input) {
		validInteger(input);
		validPositive(input);
	}

	private void validInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
		}
	}

	private void validPositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수이어야 한다.");
		}
	}

	public boolean isSame(PlayTime playTime) {
		return this.equals(playTime);
	}

	public void increase() {
		this.round += 1;
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
}
