package racingcar.view;

import racingcar.domain.CarList;

public class Output {
	static final String MSG_RACE_START = "\n실행 결과";
	static final String MSG_WINNER_IS = "최종 우승자 : ";
	static final String WINNERS_JOIN_DELIMITER = ", ";

	public static void startRaceMsg() {
		System.out.println(MSG_RACE_START);
	}

	public static void movementState(CarList cars) {
		for (String state : cars.getMovementState()) {
			System.out.println(state);
		}
		System.out.println();
	}

	public static void winners(CarList cars) {
		System.out.println(MSG_WINNER_IS
			+ String.join(WINNERS_JOIN_DELIMITER, cars.getWinners()));
	}
}
