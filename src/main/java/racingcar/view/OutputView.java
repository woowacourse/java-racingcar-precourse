package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.WinnerDto;

public class OutputView {
	private static final String TRIAL_RESULT = "실행 결과";
	private static final String CAR_POSITION_PARTITION_FORMAT = " : ";
	private static final String POSITION_INDICATOR = "-";
	private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

	public static void printGameStartMessage() {
		System.out.println(TRIAL_RESULT);
	}

	public static void printRacingCurrentSituation(Cars cars) {
		List<Car> participants = cars.getCars();
		for (Car car : participants) {
			String position = currentPosition(car);
			System.out.println(car.getName() + CAR_POSITION_PARTITION_FORMAT + position);
		}
		System.out.println();
	}

	private static String currentPosition(Car car) {
		StringBuilder sb = new StringBuilder();
		int position = car.getPosition();
		for (int i = 0; i < position; i++) {
			sb.append(POSITION_INDICATOR);
		}
		return sb.toString();
	}

	public static void printWinner(WinnerDto winners) {
		System.out.print(WINNER_ANNOUNCEMENT);
		String winner = String.join(", ", winners.getNames());

		System.out.println(winner);
	}

}
