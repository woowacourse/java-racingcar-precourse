package racingcar.view;

import java.util.List;

import racingcar.model.RacingCars;

public class Output {

	static final String NAME_CONNECTION_POSITION_STRING = " : ";
	static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
	static final String WINNER_NAME_DISTINGUISH_STRING = ", ";
	static final int STRING_START_INDEX = 0;
	static final int STRING_FIND_LAST_INDEX = -2;

	public void reportThisRoundResult(RacingCars racingCars) {
		racingCars.racingCars.forEach(
			car -> System.out.println(
				car.getName() + NAME_CONNECTION_POSITION_STRING + car.convertPositionIntToSymbol())
		);
		System.out.println();
	}

	public void reportFinalResult(List<String> winners) {
		StringBuilder finalResultMessage = new StringBuilder(FINAL_WINNER_MESSAGE);
		for (String winner : winners) {
			finalResultMessage.append(winner).append(WINNER_NAME_DISTINGUISH_STRING);
		}
		System.out.println(finalResultMessage.substring(STRING_START_INDEX, finalResultMessage.length() + STRING_FIND_LAST_INDEX));
	}
}
