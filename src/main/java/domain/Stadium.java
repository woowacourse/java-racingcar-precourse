package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Stadium {

	private static final int ZERO = 0;
	private static final int MAX_LENGTH = 5;

	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Car> carList;

	public void runRacingCar() {
		List<String> carNames = getCarNamesFromUser();
		int numOfRace = getNumberOfRace();
		getReadyRacingCars(carNames);
		runRace(numOfRace);

		ArrayList<String> firstRunners = getFirstRunners();
		printWinners(firstRunners);
	}

	private List<String> getCarNamesFromUser() {
		List<String> cars;

		do {
			System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
			String input = scanner.nextLine();
			cars = Arrays.asList(input.replaceAll("\\s", "").split(","));
		} while (isNull(cars) || !isValidLengthOfName(cars));

		return cars;
	}

	private boolean isNull(List<String> cars) {
		if (cars.size() == ZERO) {
			System.out.println("입력값 형식이 잘못되었습니다.");
			return true;
		}
		return false;
	}

	private boolean isValidLengthOfName(List<String> cars) {
		for (String car : cars) {
			if (car.length() > MAX_LENGTH || car.isEmpty()) {
				System.out.println("차량 이름은 1이상 5이하로 입력 해주세요.");
				return false;
			}
		}
		return true;
	}

	private int getNumberOfRace() {
		String numberOfRace;

		while (true) {
			System.out.println("시도할 횟수는 몇회인가요");
			numberOfRace = scanner.nextLine();

			if (!isNumeric(numberOfRace)) {
				System.out.println("숫자만 입력 가능합니다.");
				continue;
			}

			return Integer.parseInt(numberOfRace);
		}

	}

	private boolean isNumeric(String input) {
		if (input == null || input.length() == 0) {
			return false;
		}
		return input.chars().allMatch(Character::isDigit);
	}

	private void getReadyRacingCars(List<String> carNames) {
		carList = new ArrayList<>(carNames.size());

		for (String carName : carNames) {
			Car car = new Car(carName);
			carList.add(car);
		}
	}

	private void runRace(int numOfRace) {
		System.out.println("실행 결과");

		for (int i = 0; i < numOfRace; i++) {
			for (Car car : carList) {
				car.move();
				printPositions(car);
			}
			System.out.println("");
		}
	}

	private void printPositions(Car car) {
		StringBuilder sb = new StringBuilder();
		int position = car.getPosition();
		sb.append(car.getName());
		sb.append(": ");

		for (int i = 0; i < position; i++) {
			sb.append("-");
		}

		System.out.println(sb.toString());
	}

	private ArrayList<String> getFirstRunners() {
		ArrayList<String> firstRunners = new ArrayList(carList.size());
		ArrayList<Integer> positions = new ArrayList(carList.size());
		for (Car car : carList) {
			int position = car.getPosition();
			positions.add(position);
		}
		int firstRunnersPosition = (int)Collections.max(positions);
		for (Car car : carList) {
			if (car.getPosition() == firstRunnersPosition) {
				firstRunners.add(car.getName());
			}
		}
		return firstRunners;
	}

	private void printWinners(ArrayList<String> firstRunners) {
		StringBuilder sb = new StringBuilder();

		for (String firstRunner : firstRunners) {
			if (sb.length() > ZERO) {
				sb.append(",");
			}
			sb.append(firstRunner);
		}

		sb.append("가 최종 우승했습니다.");
		System.out.println(sb.toString());

	}

}
