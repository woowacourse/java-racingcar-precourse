package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

	private final String startMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준로 구분)";
	private final String tryMessage = "시도할 회수는 몇회인가요?";
	private List<Car> participantList = new LinkedList<>();
	private int rounds = 0;

	public void startGame() {
		System.out.println(startMessage);
	}

	private void updateGameInformation(String participants, int rounds) {
		StringTokenizer participant = new StringTokenizer(participants, ",");
		while (participant.hasMoreTokens()) {
			participantList.add(new Car(participant.nextToken()));
		}
		this.rounds = rounds;
	}
}
