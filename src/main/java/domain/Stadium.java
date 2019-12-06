package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Stadium {

	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Car> carList;

	public void runRacingCar() {
		List<String> carNames = getCarNamesFromUser();
		int numOfRace = getNumberOfRace();
	}

	private List<String> getCarNamesFromUser() {
		List<String> cars;

		do {
			System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
			String input = scanner.nextLine();
			cars = Arrays.asList(input.replaceAll("\\s", "").split(","));

			System.out.println(cars);
			System.out.println(cars.size());

		} while (isNull(cars) || !isValidLengthOfName(cars));

		return cars;
	}

	private boolean isNull(List<String> cars) {
		if (cars.size() == 0) {
			System.out.println("입력값 형식이 잘못되었습니다.");
			return true;
		}
		return false;
	}

	private boolean isValidLengthOfName(List<String> cars) {
		for (String car : cars) {
			System.out.println("차량 이름:" + car);
			if (car.length() > 5 || car.isEmpty()) {
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
}
