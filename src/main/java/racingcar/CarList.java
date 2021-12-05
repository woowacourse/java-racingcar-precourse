package racingcar;

import java.util.ArrayList;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class CarList {
	private ArrayList<Car> carList;
	private ArrayList<String> carNameList;

	ArrayList<Car> getList() {
		return carList;
	}

	private void initAttributes() {
		carList = new ArrayList<>();
		carNameList = new ArrayList<>();
	}

	CarList() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		boolean passed = false;
		while (!passed) {
			initAttributes();
			passed = tryToMakeCarList();
		}
	}

	private boolean tryToMakeCarList() {
		try {
			Stream<String> carNames = new StreamMaker().getCarNames();
			new CarListOperator().initCarListWithStream(carNames);
			return true;
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return false;
		}
	}

	// 이름을 입력받으면 이름리스트/자동차리스트에 각각 추가한다.
	class CarListOperator {
		private String carName;

		public void initCarListWithStream(Stream<String> carNames) {
			carNames.forEach(this::add);
		}

		public void add(String name) {
			this.carName = name;
			if (carNameList.contains(carName)) {
				throw new IllegalArgumentException("[ERROR] 자동차이름은 중복이 불가능 합니다.");
			}
			addCarName();
			addCarList();
		}

		private void addCarName() {
			carNameList.add(carName);
		}

		private void addCarList() {
			carList.add(new Car(carName));
		}
	}

	public void printWinner() {
		new Winner();
	}

	class Winner {
		int maxPosition = 0;
		ArrayList<String> winnerList = new ArrayList<>();

		Winner() {
			pick();
			print();
		}

		void pick() {
			for (Car c : carList) {
				if (c.getPosition() < maxPosition) {
					continue;
				} else if (maxPosition < c.getPosition()) {
					winnerList = new ArrayList<>();
				}
				winnerList.add(c.getName());
			}
		}

		void print() {
			String winners = String.join(", ", winnerList);
			System.out.printf("최종 우승자 : %s", winners);
		}

	}

}

// 문자열을 입력받아서, 스트림으로 구분해서 반환한다.
class StreamMaker {
	private String inputStr;

	Stream<String> getCarNames() {
		return Stream.of(inputStr.split(","));
	}

	StreamMaker() {
		inputStrOfCarNames();
	}

	private void inputStrOfCarNames() {
		inputStr = Console.readLine();

		if (!inputStr.matches("[a-zA-Z0-9,]+")) {
			throw new IllegalArgumentException("[ERROR] 자동차이름(영문/숫자), 쉼표만 입력 가능합니다.");
		}
	}
}