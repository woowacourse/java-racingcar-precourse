package racingcar.controller;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	public static final int MIN_RANDOM = 0;
	public static final int MAX_RANDOM = 9;
	public static final int MOVE_CONDITION = 4;

	private InputView inputView;
	private OutputView outputView;

	public RaceController() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void start() {
		ArrayList<String> names = getProperNames();
		Car[] cars = enrollCars(names);
		int moveCount = getProperMoveCount();

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

	private Car[] enrollCars(ArrayList<String> names) {
		Car[] cars = new Car[names.size()];
		for (int i = 0; i < names.size(); i++) {
			cars[i] = new Car(names.get(i));
		}
		return cars;
	}

	private int getProperMoveCount() {
		int moveCount = inputView.enterMovesWithValidation();
		return moveCount;
	}


}
