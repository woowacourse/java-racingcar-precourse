package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

	public static void main(String[] args) {

	}


	private Entry makeRacingEntry(List<String> carNameList) {
		List<Car> carList = new ArrayList<>();

		for (String carName : carNameList) {
			carList.add(new Car(carName));
		}

		return new Entry(carList);
	}

	private static List<String> getCarNameList(String carNames) {
		List<String> carNameList = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(carNames, ",");

		while (tokenizer.hasMoreTokens()) {
			carNameList.add(tokenizer.nextToken());
		}

		return carNameList;
	}

	private static void printToInputCarNamesMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	private static void printToInputMoveCountMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}
}
