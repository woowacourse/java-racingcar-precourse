package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class OutputView {
	private static final String STRING_CAR_POSITION = "-";
	private static final String FINAL_WINNER_TITLE_MESSAGE = "최종 우승자 : ";

	public static void printCarsStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + getStringOfCarPosition(car.getPosition()));
		}
		System.out.println();
	}

	private static String getStringOfCarPosition(int carPosition) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append(STRING_CAR_POSITION);
		}
		return stringBuilder.toString();
	}

	public static void printFinalCarWinners(CarRepository carRepository) {
		System.out.println(FINAL_WINNER_TITLE_MESSAGE + String.join(", ", carRepository.getWinnerCarsName()));
	}
}
