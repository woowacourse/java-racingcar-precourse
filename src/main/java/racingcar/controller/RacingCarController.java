package racingcar.controller;

import java.util.ArrayList;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.util.Converter;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public void run() {
		String[] carNames = getCarNames();
		int stageNum = getStageNum();
		RacingCars racingCars = makeRacingCars(carNames);

		OutputView.printRacingStart();
		playRacing(stageNum, racingCars);
		OutputView.printWinners(racingCars.getWinners());
	}

	private void playRacing(int stageNum, RacingCars racingCars) {
		for (int i = 0; i < stageNum; i++) {
			racingCars.go();
			OutputView.printResult(racingCars);
		}
	}

	private RacingCars makeRacingCars(String[] carNames) {
		ArrayList<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}

		return new RacingCars(cars);
	}

	private int getStageNum() {
		int stageNum;
		try {
			stageNum = enterStageNum();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return getStageNum();
		}

		return stageNum;
	}

	private String[] getCarNames() {
		String[] names;
		try {
			names = enterCarName();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e);
			return getCarNames();
		}

		return names;
	}

	private int enterStageNum() {
		OutputView.printEnterStageNum();
		String input = InputView.readLine();
		int stageNum = Converter.toInt(input);
		Validator.validateStageNum(stageNum);

		return stageNum;
	}

	private String[] enterCarName() {
		OutputView.printEnterCarNames();
		String input = InputView.readLine();
		String[] names = Converter.toStringArray(input);
		Validator.validateCarNames(names);

		return names;
	}
}
