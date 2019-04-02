package domain;

import java.util.Scanner;

public class GameUI {
	private Game game;

	public GameUI() {
		this.game = new Game();
	}

	public String askCarNames(Scanner sc) {
		String carNames;
		String info = "경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)";

		System.out.println(info);
		carNames = sc.nextLine();

		return carNames;
	}

	public int askLapNum(Scanner sc) {
		int lapNum;
		String info = "시도할 회수는 몇회인가요?";

		System.out.println(info);
		lapNum = Integer.parseInt(sc.nextLine());

		return lapNum;
	}
}
