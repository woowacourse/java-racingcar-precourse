package racingcar.view;

import static racingcar.util.SymbolicConstantUtil.*;

import racingcar.domain.Car;
import racingcar.domain.RacingRecord;

public class OutputView {

	public static void printRacingRecord(RacingRecord racingRecord) {
		for (Car car : racingRecord.getRacingRecord()) {
			System.out.println(car.getName() + COLON + printDash(car.getPosition()));
		}
	}

	private static String printDash(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(DASH);
		}
		return stringBuilder.toString();
	}
}
