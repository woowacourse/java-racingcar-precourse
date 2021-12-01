package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public boolean carsScan = true;
	public boolean numberScan = true;
	public String[] carsList;
	public int numberOfMove;

	public void scanCarsList() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carsInput = Console.readLine();
		carsList = carsInput.split(",");
		isValidCars(carsList);
	}

	public void scanNumberOfMove() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String numberOfMove = Console.readLine();
		isValidNumber(numberOfMove);
		this.numberOfMove = toInt(numberOfMove);
	}

	public void isValidCars(String[] carsList) throws IllegalArgumentException {
		for (int i = 0; i < carsList.length; i++) {
			if (carsList[i].length() > 5) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
			}
		}
		carsScan = false;
	}

	public void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
		}
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit((number.charAt(i)))) {
				throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
			}
		}
		numberScan = false;
	}

	public int toInt(String number) {
		return Integer.parseInt(number);
	}

	public void scanCars() {
		while (carsScan) {
			try {
				scanCarsList();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumber() {
		while (numberScan) {
			try {
				scanNumberOfMove();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
