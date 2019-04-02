package domain;

import java.util.Scanner;

public class GameUI {
	private Game game;

	public GameUI() {
		this.game = new Game();
	}

	public String askCarNames(Scanner sc) {
		String carNames;
		String info = "경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)";

		System.out.println(info);
		carNames = sc.nextLine();

		return carNames;
	}
}
