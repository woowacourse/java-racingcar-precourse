package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarListMaker {
	ArrayList<Car> carList = new ArrayList<>();

	ArrayList<Car> getCarList() {
		return this.carList;
	}

	CarListMaker() {
		makeList();
	}

	private void makeList() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		boolean passed = false;
		while (!passed) {
			String chunkOfCarNames = new NameStringMaker().getNameString();
			passed = isValidList(chunkOfCarNames);
		}
	}

	private boolean isValidList(String chunkOfCarNames) {
		try {
			carList = getCarList(chunkOfCarNames);
		} catch (IllegalArgumentException error) {
			carList = new ArrayList<>();
			System.out.println(error.getMessage());
			return false;
		}
		return true;
	}

	private ArrayList<Car> getCarList(String chunkOfCarNames) throws IllegalArgumentException {
		InputValidator validator = new InputValidator();
		for (String carName : splitStrToListByComma(chunkOfCarNames)) {
			validator.hasValidLengthAndNoDuplication(carName);
			carList.add(new Car(carName));
		}
		return carList;
	}

	private List<String> splitStrToListByComma(String str) {
		String[] arr = str.split(",");
		return Arrays.asList(arr);
	}
}

