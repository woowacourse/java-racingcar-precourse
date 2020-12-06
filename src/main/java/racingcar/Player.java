package racingcar;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utils.Validator;

public class Player {
	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	private static final String COUNT_QUESTION = "시도할 회수는 몇회인가요?";
	
	private String car;
	private List<String> carNames;
	
	private int triedCnt;
	
	public void inputRacingCar(Scanner scanner) {
		inputCar(scanner);
		inputTriedCnt(scanner);
		
		GameManager.setCar(carNames);
		GameManager.setTriedCount(triedCnt);
	}
	
	private void inputCar(Scanner scanner) {
		while (true) {
			System.out.println(START_MESSAGE);
			this.car = scanner.nextLine();
			this.carNames = Arrays.asList(car.replaceAll(" ", "").split(","));
			
			if (Validator.isUseableCar(carNames)) {
				return;
			}
			System.out.println("[ERROR] 자동차 이름은 1자 이상, 5자 이하여야 한다.\n");
		}
	}
	
	private void inputTriedCnt(Scanner scanner) {
		while (true) {
			System.out.println(COUNT_QUESTION);
			
			try {
				this.triedCnt = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.\n");
				scanner.nextLine();
				continue;
			}
			
			if (Validator.isUseableTriedCnt(triedCnt)) {
				return;
			}
			System.out.println("[ERROR] 시도 횟수는 0보다 커야 한다.\n");
		}
		
	}
}
