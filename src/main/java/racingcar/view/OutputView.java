package racingcar.view;

import static racingcar.util.SymbolicConstantUtil.*;

import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;

public class OutputView {
	private static final String RESPONSE_RACE_WINNERS = "최종 우승자 : ";
	private static final String RESPONSE_RACE_RECORD = "실행 결과";

	public static void printRacingRecordHeadLine() {
		System.out.println();
		System.out.println(RESPONSE_RACE_RECORD);
	}

	public static void printRacingRecord(RacingRecord racingRecord) {
		for (Car car : racingRecord.getRacingRecord()) {
			System.out.println(car.getName() + COLON + printDash(car.getPosition()));
		}
	}

	public static void printRacingWinners(RacingResult racingResult) {
		System.out.println(RESPONSE_RACE_WINNERS + appendComma(racingResult));
	}

	private static String appendComma(RacingResult racingResult) {
		return racingResult.getWinners().stream()
			.map(Car::getName)
			.collect(Collectors.joining(COMMA));
	}

	private static String printDash(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(DASH);
		}
		return stringBuilder.toString();
	}
}
