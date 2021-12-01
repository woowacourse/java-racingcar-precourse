package view;

import domain.CarDto;

public class OutputView {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	private static final String NAME_PROGRESS_SEPARATOR = " : ";
	private static final String PROGRESS_BAR = "-";

	public static void printErrorMessage(String errorMessage) {
		System.out.println("[ERROR] " + errorMessage);
	}

	public static void printInputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
	}

	public static void printInputMoveCount() {
		System.out.println(INPUT_MOVE_COUNT_MESSAGE);
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
}
