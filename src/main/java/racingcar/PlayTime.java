package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class PlayTime {
	public static final String ASK_PLAYTIME = "시도할 회수는 몇회인가요?";
	private Integer round = 0;

	public void getInput() {
		System.out.println(ASK_PLAYTIME);
		String input = readLine();
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
