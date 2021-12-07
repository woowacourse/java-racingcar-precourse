package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.Message;
import racingcar.utils.Validation;

public class InputView {
	private ArrayList<Car> carsList = new ArrayList<Car>();

	public ArrayList<Car> getCarsList() {
		List<String> carsNameList = carNamesInput();
		createCarsList(carsNameList);
		return carsList;
	}

	public List<String> carNamesInput() {
		List<String> carsNameList = new ArrayList<String>();
		do {
			System.out.println(Message.ASK_CAR_NAMES);
			String carNames = Console.readLine();
			String[] carArray = carNames.split(",");
			carsNameList = Arrays.asList(carArray);
		} while (!checkRightNames(carsNameList));

		return carsNameList;
	}

	public void createCarsList(List<String> carsNameList) {
		for (int i = 0; i < carsNameList.size(); i++) {
			carsList.add(new Car(carsNameList.get(i)));
		}
	}

	public int getGameCount() {
		String stringGameCount = "";
		int gameCount = 0;

		do {
			System.out.println(Message.ASK_GAME_COUNT);
			stringGameCount = Console.readLine();
		} while (!checkRightGameCount(stringGameCount));

		gameCount = gameCountParser(stringGameCount);
		System.out.println(gameCount);
		return gameCount;
	}

	public int gameCountParser(String stringGameCount) {
		int gameCount = Integer.parseInt(stringGameCount);
		return gameCount;
	}

	public boolean checkRightNames(List<String> carsNameList) {
		boolean isRightNames = true;
		Validation validation = new Validation();

		try {
			validation.LESS_MORE_NAME_ERROR(carsNameList);
			validation.CONTAIN_SAME_NAME_ERROR(carsNameList);
			validation.WHITE_SPACE_NAME_ERROR(carsNameList);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNames = false;
		}
		return isRightNames;
	}

	public boolean checkRightGameCount(String stringGameCount) {
		boolean isRightNumeric = true;
		Validation validation = new Validation();

		try {
			validation.NON_NUMERIC_GAME_COUNT_ERROR(stringGameCount);
			validation.ZERO_GAME_COUNT_ERROR(stringGameCount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNumeric = false;
		}
		return isRightNumeric;
	}

}
