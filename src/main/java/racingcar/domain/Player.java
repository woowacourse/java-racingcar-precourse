package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import racingcar.util.Validator;
import racingcar.view.InputView;

public class Player {
	public final int ZERO = 0;
	public final String ENTER_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public final String ENTER_MOVE_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	public List<String> enterCarsName() {
		String cars = "";
		do {
			System.out.println(ENTER_CARS_MESSAGE);
			try {
				cars = isValidateName(InputView.getInput());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (cars.equals(""));
		return makeInputToList(cars);
	}

	public int enterMoveNum() {
		int moveNum = ZERO;
		do {
			System.out.println(ENTER_MOVE_NUMBER_MESSAGE);
			try {
				moveNum = isValidateNumber(InputView.getInput());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (moveNum == ZERO);
		return moveNum;
	}

	private String isValidateName(String input) throws IllegalArgumentException {
		String[] names = input.trim().split(",");
		for (String name : names) {
			Validator.isLengthOverFive(name);
		}
		return input;
	}

	private List<String> makeInputToList(String input) {
		return Arrays.asList(input.trim().split(","));
	}

	private int isValidateNumber(String input) {
		Validator.isNumber(input);
		return Integer.parseInt(input);
	}

}
