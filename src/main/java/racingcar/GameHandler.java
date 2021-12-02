package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameHandler {
	private int stages;
	private List<Car> cars = new ArrayList<>();

	public void run() {
		createCars();
		getStages();
		System.out.println("실행 결과");
		while (stages-- > 0) {
			executeStage();
		}
		showWinners();
	}

	private void showWinners() {
		List<Car> winnerCars = findWinnerCars();

		System.out.print("최종 우승자 : ");
		StringBuilder winners = getWinners(winnerCars);
		System.out.println(winners);
	}

	private StringBuilder getWinners(List<Car> winnerCars) {
		StringBuilder winners = new StringBuilder();
		for (int i = 0; i < winnerCars.size(); i++) {
			winners.append(winnerCars.get(i).name());
			if (i != winnerCars.size() - 1) {
				winners.append(", ");
			}
		}
		return winners;
	}

	private List<Car> findWinnerCars() {
		List<Car> winners = new ArrayList<>();
		List<Car> carList = new ArrayList<>(cars);

		carList.sort(Comparator.comparingInt(Car::currentPosition));
		int max = carList.get(carList.size() - 1).currentPosition();
		for (int i = carList.size() - 1; i >= 0; i--) {
			if (carList.get(i).currentPosition() < max) {
				break;
			}
			winners.add(carList.get(i));
		}

		return winners;
	}

	private void executeStage() {
		moveAllCars();
		showEachStageResult();
	}

	private void moveAllCars() {
		for (Car car : cars) {
			car.go();
		}
	}

	private void showEachStageResult() {
		for (Car car : cars) {
			System.out.print(car.name() + " : ");
			for (int i = 0; i < car.currentPosition(); i++) {
				System.out.print("-");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void getStages() {
		System.out.println("시도할 회수는 몇회인가요?");

		while (true) {
			if (getUserInputStage()) {
				break;
			}
		}
	}

	private boolean getUserInputStage() {
		try {
			String input = Console.readLine();
			if (isNotNumber(input)) {
				throw new IllegalArgumentException();
			}
			this.stages = Integer.parseInt(input);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 시도할 횟수는 숫자여야 합니다");
		}
		return false;
	}

	private boolean isNotNumber(String input) {
		return !input.chars().allMatch(Character::isDigit);
	}

	private void createCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String[] names = getCarsName();
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	private String[] getCarsName() {
		String[] names;

		while (true) {
			try {
				names = getUserInputNames();
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 자동차의 이름은 1~5글자 입니다");
			}
		}

		return names;
	}

	private String[] getUserInputNames() {
		String userInput = Console.readLine();

		if (checkValidNames(userInput)) {
			return userInput.split(Constant.SPLIT_STRING);
		}

		throw new IllegalArgumentException();
	}

	private boolean checkValidNames(String userInput) {
		String[] names = userInput.split(Constant.SPLIT_STRING);
		for (String name : names) {
			if (isInvalidNameLength(name)) {
				return false;
			}
		}

		if (isLastCharImproper(userInput)) {
			return false;
		}

		return true;
	}

	private boolean isInvalidNameLength(String name) {
		return !(Constant.MIN_NAME_LENGTH <= name.length() && name.length() <= Constant.MAX_NAME_LENGTH);
	}

	private boolean isLastCharImproper(String userInput) {
		return userInput.charAt(userInput.length() - 1) == Constant.IMPROPER_CHARACTER;
	}
}
