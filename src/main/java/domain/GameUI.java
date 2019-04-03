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
	private static final String INFO_MESSAGE_CAR_NAME = String.format("경주할 자동차 이름을 입력하세요.(이름은쉼표(%s)기준으로구분)", DELIMITER);
	private static final String ERR_MESSAGE_CAR_NAME_LENGTH = String.format("자동차 이름은 %d글자 이하입니다.", Car.MAX_NAME_LENGTH);
	private static final String INFO_MESSAGE_LAP_NUM = "시도할 회수는 몇회인가요?";
	private static final String INFO_MESSAGE_RACING_RESULT = "\n실행결과";
	private Game game;

	public GameUI() {
		this.game = new Game();
	}

	public void run() {
		try (Scanner sc = new Scanner(System.in)) {
			String carNames = askCarNames(sc);
			this.game.joinRace(carNames, DELIMITER);

			int lapNum = askLapNum(sc);
			startRace(lapNum);
		}
	}

	private String askCarNames(Scanner sc) {
		while (true) {
			System.out.println(INFO_MESSAGE_CAR_NAME);
			String carNames = sc.nextLine();

			/* 유효성 검사를 통과할 때까지 사용자 정확한 입력 요청한다. */
			try {
				isValidCarNames(carNames);
			} catch (NameRuleException e) {
				System.err.println(e.getMessage());
				continue;
			}
			return carNames;
		}
	}

	private void isValidCarNames(String carNames) throws NameRuleException {
		for (String carName : carNames.split(DELIMITER)) {
			if (carName.length() > Car.MAX_NAME_LENGTH) {
				throw new NameRuleException(ERR_MESSAGE_CAR_NAME_LENGTH);
			}
		}
	}

	private int askLapNum(Scanner sc) {
		int lapNum;

		System.out.println(INFO_MESSAGE_LAP_NUM);
		lapNum = Integer.parseInt(sc.nextLine());

		return lapNum;
	}

	private void startRace(int lapNum) {
		System.out.println(INFO_MESSAGE_RACING_RESULT);
		for (int i = 0; i < lapNum; i++) {
			this.game.runLap();
			showLapResult();
		}
		showRaceChampion();
	}

	private void showLapResult() {
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

	private void showRaceChampion() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> champions = this.game.getRaceChampion();
		int lastChampionIndex = champions.size() - 1;

		for (int i = 0; i < lastChampionIndex; i++) {
			sb.append(champions.get(i)).append(", ");
		}
		sb.append(champions.get(lastChampionIndex)).append("가 최종 우승했습니다.");

		System.out.println(sb.toString());
	}
}