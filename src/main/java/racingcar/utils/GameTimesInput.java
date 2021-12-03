package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.validator.GameTimesValidator;

public class GameTimesInput {

	private GameTimesValidator gameTimesValidator;

	public GameTimesInput(){
		gameTimesValidator = new GameTimesValidator();
	}

	public int getGameTimes(){
		String times;
		do {
			System.out.println("시도할 회수는 몇회인가요?");
			times = Console.readLine();
		}while (gameTimesValidator.isInvalidTimes(times));
		return Integer.parseInt(times);
	}
}
