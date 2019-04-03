/*
 * @(#) GameUI.java     1.0   2019/04/02
 *
 * Released under the MIT license
 */

package domain;

import err.NameRuleException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GameUI 클래스는 사용자와 자동차경주게임을 위한 사용자 인터페이스다.
 *
 * @author 조남균
 * @version 1.00  2019년 04월 02일
 */
public class GameUI {
	private static final String DELIMITER = ",";
	private Game game;

	public GameUI() {
		this.game = new Game();
	}

	public void run() {
		try (Scanner sc = new Scanner(System.in)) {
			String carNames = askCarNames(sc);
			this.game.joinRace(carNames);

			int lapNum = askLapNum(sc);
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

	private void isValidCarNames(String carNames) throws NameRuleException {
		for (String carName : carNames.split(DELIMITER)) {
			if (carName.length() > Car.NAME_LENGTH) {
				throw new NameRuleException("5글자 이상");
			}
		}
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