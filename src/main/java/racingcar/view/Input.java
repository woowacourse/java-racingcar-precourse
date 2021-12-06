package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.exception.CarNameException.*;
import static racingcar.exception.CountException.*;

public class Input {

	static final String CAR_NAME_DISTINGUISH_STRING = ",";
	private static final String CARS_NAME_INPUT_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String COUNT_INPUT_MASSAGE = "시도할 회수는 몇회인가요?";

	public String[] requestCarsName() {
		System.out.println(CARS_NAME_INPUT_MASSAGE);
		while (true) {
			String carsName = readLine();
			String[] carNameList = convertStringToArraysByComma(carsName);
			try {
				checkCarNameException(carNameList);
				return carNameList;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public String[] convertStringToArraysByComma(String carsName) {
		return carsName.split(CAR_NAME_DISTINGUISH_STRING);
	}

	public int requestCount() {
		System.out.println(COUNT_INPUT_MASSAGE);
		while (true) {
			String countInput = readLine();
			try {
				checkCountException(countInput);
				return Integer.parseInt(countInput);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
