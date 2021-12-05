package view;

import java.util.List;

import domain.CarDto;
import domain.WinnersDto;

public class OutputView {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String RESULT_MESSAGE = "실행결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	private static final String NAME_PROGRESS_SEPARATOR = " : ";
	private static final String PROGRESS_BAR = "-";
	private static final String WINNER_DELIMITER = ", ";

	public static void printErrorMessage(String errorMessage) {
		System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
	}

	public static void printInputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
	}

	public static void printInputTryCount() {
		System.out.println(INPUT_TRY_COUNT_MESSAGE);
	}

	public static void printResultMessage() {
		System.out.println("\n" + RESULT_MESSAGE);
	}

	public static void printCar(CarDto carDto) {
		String name = carDto.getName();
		int position = carDto.getPosition();

		System.out.print(name + NAME_PROGRESS_SEPARATOR);
		for (int i = 0; i < position; i++) {
			System.out.print(PROGRESS_BAR);
		}

		System.out.println();
	}

	public static void printCars(List<CarDto> carDtos) {
		carDtos.forEach(OutputView::printCar);
		System.out.println();
	}

	public static void printWinners(WinnersDto winnersDto) {
		String winners = String.join(WINNER_DELIMITER, winnersDto.getWinnerNames());
		System.out.println(WINNER_MESSAGE + winners);
	}
}
