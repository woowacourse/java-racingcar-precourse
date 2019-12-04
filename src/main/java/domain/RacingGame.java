package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private Scanner sc;
	private List<Car> carList;
	private int racingCount;

	public RacingGame() {
		sc = new Scanner(System.in);
		carList = new ArrayList<>();
	}

	public void startGame() {

	}

	private boolean inputCarName() {
		boolean isAvailable = false;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = sc.nextLine();

		return isAvailable;
	}

	private boolean inputRacingCount() {
		boolean isAvailable = false;

		System.out.println("시도할 횟수는 몇회인가요?");
		try {
			racingCount = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("숫자를 입력해 주세요!!!!!!");
		}

		return isAvailable;
	}

}
