package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	private List<String> carNames;

	public void run() {
		inputCarNames();
	}

	private void inputCarNames() {
		System.out.println(Message.RACING_CAR_NAME_INPUT_MESSAGE);
		String[] carNames = Console.readLine().split(",");

		this.carNames = Arrays.asList(carNames);
	}

}
