package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import racingcar.util.Validator;
import racingcar.view.InputView;

public class Player {
	private InputView inputView;
	private Validator validator;

	public final String ENTER_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public List<String> enterCarsName() {
		String cars = "";
		do {
			System.out.println(ENTER_CARS_MESSAGE);
			try {
				cars = validateInput(inputView.getInput());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}while(cars.equals(""));
		return makeInputToList(cars);
	}

	private String validateInput(String input) throws IllegalArgumentException{
		String[] names = input.trim().split(",");
		for (String name : names) {
			validator.isLengthOverFive(name);
		}
		return input;
	}

	private List<String> makeInputToList(String input) {
		return Arrays.asList(input.trim().split(","));
	}

}
