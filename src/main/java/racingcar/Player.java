package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	private static final String COUNT_QUESTION = "시도할 회수는 몇회인가요?";
	
	Player() {}
	
	public void inputRacingCar(Scanner scanner) {
		System.out.println(START_MESSAGE);
		String car = scanner.nextLine();
		List<String> carNames = Arrays.asList(car.replaceAll(" ", "").split(","));
		
		System.out.println(COUNT_QUESTION);
		int triedCnt = scanner.nextInt();
		
		GameManager.setCar(carNames);
		GameManager.setTriedCount(triedCnt);
	}
}
