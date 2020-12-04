package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	
	Player() {}
	
	public void inputRacingCar(Scanner scanner) {
		System.out.println(START_MESSAGE);
		
		String car = scanner.next();
		List<String> carList = Arrays.asList(car.split(","));
	}
}
