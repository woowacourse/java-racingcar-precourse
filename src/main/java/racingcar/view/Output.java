package racingcar.view;

import racingcar.domain.CarList;

public class Output {
	public static void raceStartPhrase() {
		System.out.println("\n실행 결과");
	}

	public static void movementState(CarList cars) {
		for (String state : cars.getMovementState()) {
			System.out.println(state);
		}
		System.out.println();
	}

	public static void winners(CarList cars) {
		System.out.println("최종 우승자 : "
			+ String.join(", ", cars.getWinners()));
	}
}
