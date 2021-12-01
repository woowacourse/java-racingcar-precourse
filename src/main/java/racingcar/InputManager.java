package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public boolean carsScan = true;
	public boolean numberScan = true;
	public String[] carsList;
	public int numberOfMove;

	public void scanCarsList() {
		while (carsScan) {
			try {
				System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
				String carsInput = Console.readLine();
				isValidCars(carsInput);
				carsList = carsInput.split(",");
				isValidCars(carsList);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				numberScan = false;
			}
		}
	}

	public void scanNumberOfMove() {
		while (numberScan) {
			try {
				System.out.println("시도할 횟수는 몇회인가요?");
				String numberOfMove = Console.readLine();
				isValidNumber(numberOfMove);
				this.numberOfMove = toInt(numberOfMove);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void isValidCars(String[] carsList) throws IllegalArgumentException {
		for (String car : carsList) {
			if (car.length() > 5) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
			}
		}
		carsScan = false;
	}

	public void isValidCars(String carsInput) throws IllegalArgumentException {
		if (carsInput.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
		}
		carsScan = false;
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
		numberScan = false;
	}

	public int toInt(String number) {
		return Integer.parseInt(number);
	}
}
