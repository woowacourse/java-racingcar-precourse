package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public String[] scanCarsList() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carsInput = Console.readLine();
		String[] carsList = carsInput.split(",");
		isValidInput(carsList);
		return carsList;
	}

	public void isValidInput(String[] carsList) throws IllegalArgumentException {
		for (int i = 0; i < carsList.length; i++) {
			if (carsList[i].length() > 5) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름을 5자리 이하로 정해주세요.");
			}
		}
	}
}
