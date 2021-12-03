package racingcar.view;

import racingcar.domain.CarRepository;

public class OutputView {
	private static final String FINAL_WINNER_TITLE_MESSAGE = "최종 우승자 : ";

	public static void printCarsStatus(CarRepository carRepository) {
		for (String carStatusByFormatter: carRepository.getCarsStatusByFormatter()) {
			System.out.println(carStatusByFormatter);
		}
		System.out.println();
	}

	public static void printFinalCarWinners(CarRepository carRepository) {
		System.out.println(FINAL_WINNER_TITLE_MESSAGE + String.join(", ", carRepository.getWinnerCarsName()));
	}
}
