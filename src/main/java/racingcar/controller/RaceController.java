package racingcar.controller;

import java.util.ArrayList;

import racingcar.domain.Car;
import racingcar.view.InputView;

public class RaceController {
	private static InputView inputView;

	public RaceController() {
		inputView = new InputView();
	}

	public void start() {
		ArrayList<String> names = getProperNames();
		Car[] cars = enrollCars(names);
	}

	private Car[] enrollCars(ArrayList<String> names) {
		Car[] cars = new Car[names.size()];
		for (int i = 0; i < names.size(); i++) {
			cars[i] = new Car(names.get(i));
		}
		return cars;
	}

	private ArrayList<String> getProperNames() {
		ArrayList<String> names = new ArrayList<>();
		boolean needProperNames = true;
		while (needProperNames) {
			String inputValues = inputView.enterNames();
			names = inputView.convertToArrayList(inputValues);
			needProperNames = inputView.validateNames(names);
		}
		return names;
	}
}
