package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public String[] carsList;
	public int numberOfMove;

	public void scanCarsList() {
		boolean carsScan = true;
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		while (carsScan) {
			try {
				String carsInput = Console.readLine();
				isValidCars(carsInput);
				carsScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumberOfMove() {
		boolean numberScan = true;
		System.out.println("시도할 횟수는 몇회인가요?");
		while (numberScan) {
			try {
				String numberOfMove = Console.readLine();
				isValidNumber(numberOfMove);
				this.numberOfMove = toInt(numberOfMove);
				numberScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void isValidCars(String carsInput) throws IllegalArgumentException {
		String[] carsList;
		if (carsInput.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
		}
		carsList = carsInput.split(",");
		for (String car : carsList) {
			if (car.length() > 5) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
			}
		}
		this.carsList = carsList;
	}

	public void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
		}
		for (int index = 0; index < number.length(); index++) {
			if (!Character.isDigit((number.charAt(index)))) {
				throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
			}
		}
	}

	public int toInt(String number) {
		return Integer.parseInt(number);
	}
}
