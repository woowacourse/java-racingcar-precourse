package racingcar;

import static util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

class RacingGameView {
	private static RacingGameView racingGameView = new RacingGameView();

	private RacingGameView() {
	}

	public static RacingGameView getRacingGameView() {
		return racingGameView;
	}

	public List<String> getCarNames() {
		List<String> carNamesList;
		do {
			System.out.println(CAR_NAME_INPUT_MESSAGE);
			carNamesList = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
		} while (!checkLongNameException(carNamesList));
		return carNamesList;
	}

	public int getRepetitionNumber() {
		String repetitionNumber;
		do {
			System.out.println(REPETITION_NUMBER_MESSAGE);
			repetitionNumber = Console.readLine();
		} while (!checkNotNaturalNumberException(repetitionNumber));
		return Integer.parseInt(repetitionNumber);
	}

	public void printMovementStart() {
		System.out.println(MOVEMENT_RESULT_START_SENTENCE);
	}

	public void printMovement(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + car.getDashedPosition());
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		System.out.println(FINAL_RESULT_MESSAGE + String.join(", ", winners));
	}

	private boolean checkLongNameException(List<String> carNamesList) {
		try {
			if (carNamesList.stream().anyMatch(carName -> carName.length() > MAXIMUM_NAME_LENGTH)) {
				System.out.println(CAR_NAME_INPUT_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean checkNotNaturalNumberException(String repetitionNumber) {
		try {
			if (repetitionNumber.chars().anyMatch(number -> !Character.isDigit(number))) {
				System.out.println(REPETITION_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
