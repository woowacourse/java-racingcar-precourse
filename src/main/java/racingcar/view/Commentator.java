package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constants;
import racingcar.constants.ViewConstants;
import racingcar.domain.Car;
import racingcar.service.Converter;
import racingcar.service.Validator;

public class Commentator {
	private final Converter converter;
	private final Validator validator;

	public Commentator() {
		converter = new Converter();
		validator = new Validator();
	}

	public List<Car> getCarNames() {
		List<String> carNames;
		do {
			String inputString = askCarNames();
			carNames = converter.convertStringToList(inputString);
		}while(checkGetAgainCarNames(carNames));

		return converter.convertStringListToCarList(carNames);
	}

	private String askCarNames() {
		System.out.println(ViewConstants.ASK_CAR_NAMES);
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}

	private boolean checkGetAgainCarNames(List<String> carNames) {
		if(validateCarNames(carNames)) {
			return false;
		}
		printErrorWithCarNames();
		return true;
	}

	private boolean validateCarNames(List<String> carNames) {
		try {
			validator.checkCarsNameSize(carNames);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void printErrorWithCarNames() {
		System.out.println(ViewConstants.ERROR_CAR_NAMES);
	}

	public int getRuntimeNumber() {
		String numberString;
		do {
			numberString = askRuntimeNumber();
		}while(checkGetAgainRuntimeNumber(numberString));

		return converter.convertStringToInt(numberString);
	}

	private String askRuntimeNumber() {
		System.out.println(ViewConstants.ASK_RUNTIME_NUMBER);
		return readLine();
	}

	private boolean checkGetAgainRuntimeNumber(String numberString) {
		if(validateRuntimeNumber(numberString)) {
			return false;
		}
		printErrorWithRuntimeNumber();
		return true;
	}

	private boolean validateRuntimeNumber(String numberString) {
		try {
			validator.checkNumber(numberString);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void printErrorWithRuntimeNumber() {
		System.out.println(ViewConstants.ERROR_RUNTIME_NUMBER);
	}

	public void printRaceStart() {
		System.out.println(ViewConstants.NOTIFY_RESULT);
	}

	public void notifyCarsStatement(List<Car> cars) {
		for(Car car : cars) {
			car.notifyStatement();
		}
		System.out.println();
	}

	public void notifyWinners(List<String> winners) {
		printWinnerStart();
		for(int i = 0; i < winners.size(); i++) {
			System.out.print(winners.get(i));
			checkMoreWinner(i, winners.size());
		}
	}

	private void printWinnerStart() {
		System.out.print(ViewConstants.NOTIFY_RACE_WINNERS);
	}

	private void checkMoreWinner(int nowIndex, int size) {
		if(nowIndex != size - 1) {
			System.out.print(Constants.CUT_OFF_POINT + " ");
		}
	}
}
