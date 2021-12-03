package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.validator.GameTimesValidator;

public class GameTimesInput {

	private GameTimesValidator gameTimesValidator;

	public GameTimesInput(){
		gameTimesValidator = new GameTimesValidator();
	}

	public int getGameTimes(){
		String times = Console.readLine();
		gameTimesValidator.validateTimes(times);
		return Integer.parseInt(times);
	}
}
