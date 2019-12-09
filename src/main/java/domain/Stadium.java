package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stadium {

	private static final int ZERO = 0;
	private static final int MAX_LENGTH = 5;
	private static final String COLON = ": ";
	private static final String COMMA = ",";
	private static final String POSITION_MARK = "-";

	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Car> carList;

	public void runRacingCar() {
		List<String> carNames = getCarNamesFromUser();
		int numberOfRace = getNumberOfRace();

		getReadyRacingCars(carNames);
		runRace(numberOfRace);

		ArrayList<String> firstRunners = Winner.getFirstRunners(carList);
		Winner.printWinners(firstRunners);
	}

	private List<String> getCarNamesFromUser() {
		List<String> carNames;

		do {
			printMessageAskingNamesOfCars();
			String input = scanner.nextLine();
			carNames = Arrays.asList(input.replaceAll("\\s", "").split(COMMA));
		} while (isNull(carNames) || !isValidLengthOfName(carNames));

		return carNames;
	}

	private boolean isNull(List<String> cars) {
		if (cars.size() == ZERO) {
			printInputIsNullMessage();
			return true;
		}
		return false;
	}

	private boolean isValidLengthOfName(List<String> cars) {
		for (String car : cars) {
			if (car.length() > MAX_LENGTH || car.isEmpty()) {
				printValidLengthOfCarNameMessage();
				return false;
			}
		}
		return true;
	}

	private int getNumberOfRace() {
		String numberOfRace;

		while (true) {
			printMessageAskingNumberOfRace();
			numberOfRace = scanner.nextLine();

			if (!isNumeric(numberOfRace) || !isPositiveNumber(numberOfRace)) {
				continue;
			}

			return Integer.parseInt(numberOfRace);
		}
	}

	private boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException nfe) {
			printNumericOnlyMessage();
			return false;
		}
	}

	private boolean isPositiveNumber(String input) {
		if (Integer.parseInt(input) > ZERO) {
			return true;
		}
		printPositiveNumberOnlyMessage();
		return false;
	}

	private void getReadyRacingCars(List<String> carNames) {
		carList = new ArrayList<>(carNames.size());

		for (String carName : carNames) {
			Car car = new Car(carName);
			carList.add(car);
		}
	}

	private void runRace(int numberOfRace) {
		printRaceResultMessage();

		for (int i = 0; i < numberOfRace; i++) {
			isRacing(carList);
		}
	}

	private void isRacing(ArrayList<Car> carList) {
		for (Car car : carList) {
			car.move();
			printPositions(car);
		}
		System.out.println();
	}

	private void printPositions(Car car) {
		int position = car.getPosition();

		StringBuilder sb = new StringBuilder();
		sb.append(car.getName());
		sb.append(COLON);

		for (int i = 0; i < position; i++) {
			sb.append(POSITION_MARK);
		}
		System.out.println(sb.toString());
	}

	private void printInputIsNullMessage() {
		System.out.println("입력값 형식이 잘못되었습니다.");
	}

	private void printValidLengthOfCarNameMessage() {
		System.out.println("차량 이름은 1이상 5이하로 입력 해주세요.");
	}

	private void printNumericOnlyMessage() {
		System.out.println("숫자만 입력 가능합니다.");
	}

	private void printPositiveNumberOnlyMessage() {
		System.out.println("1이상의 양수만 입력가능합니다.");
	}

	private void printRaceResultMessage() {
		System.out.println("\n실행 결과");
	}

	private void printMessageAskingNumberOfRace() {
		System.out.println("시도할 횟수는 몇회인가요");
	}

	private void printMessageAskingNamesOfCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
	}

}
