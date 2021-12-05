package racingcar.view;

import static util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

public class RacingGameView {
	private static final RacingGameView racingGameView = new RacingGameView();
	private final InputValidator inputValidator;

	private RacingGameView() {
		inputValidator = InputValidator.getInputValidator();
	}

	public static RacingGameView getRacingGameView() {
		return racingGameView;
	}

	public List<String> getCarNames() {
		List<String> carNamesList;
		do {
			System.out.println(CAR_NAME_INPUT_MESSAGE);
			carNamesList = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
		} while (inputValidator.checkNameExceptions(carNamesList));
		return carNamesList;
	}

	public int getRepetitionNumber() {
		String repetitionNumber;
		do {
			System.out.println(REPETITION_NUMBER_MESSAGE);
			repetitionNumber = Console.readLine();
		} while (!inputValidator.checkRepetitionNumberExceptions(repetitionNumber));
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
}
