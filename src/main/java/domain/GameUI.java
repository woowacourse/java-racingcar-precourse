package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {
	private Game game;

	public GameUI() {
		this.game = new Game();
	}

	public void run() {
		try (Scanner sc = new Scanner(System.in)) {
			String carNames = askCarNames(sc);
			int lapNum = askLapNum(sc);

			this.game.joinRace(carNames);
			startRace(lapNum);
		}
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

	public void startRace(int lapNum) {
		String info = "\n실행결과";

		System.out.println(info);
		for (int i = 0; i < lapNum; i++) {
			this.game.runLap();
			showLapResult();
		}
		showRaceChampion();
	}

	public void showLapResult() {
		StringBuilder sb = new StringBuilder();

		for (Car car : this.game.getCars()) {
			sb.append(car.getName()).append(":");
			for (int i = 0; i < car.getPosition(); i++) {
				sb.append("-");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public void showRaceChampion() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> champions = this.game.getRaceChampion();
		int championsSize = champions.size();

		for (int i = 0; i < (championsSize - 1); i++) {
			sb.append(champions.get(i)).append(", ");
		}
		sb.append(champions.get(championsSize - 1)).append("가 최종 우승했습니다.");

		System.out.println(sb.toString());
	}
}
