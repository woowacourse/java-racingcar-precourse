package racingcar.utils.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.messages.InputMessages;
import racingcar.utils.validator.GameTimesValidator;

public class GameTimesInput {

	private GameTimesValidator gameTimesValidator;

	public GameTimesInput(){
		gameTimesValidator = new GameTimesValidator();
	}

	public int getGameTimes(){
		String times;
		do {
			System.out.println(InputMessages.TIMES_INPUT);
			times = Console.readLine();
		}while (gameTimesValidator.isInvalidTimes(times));
		return Integer.parseInt(times);
	}
}
