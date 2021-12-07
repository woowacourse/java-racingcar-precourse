package racingcar.view;

import java.util.Map;

import racingcar.domain.GameStatus;

public class ResultView {
	private static final String RESULT_HEADER = "실행 결과";
	private static final String ONE_STEP = "-";

	public void showResultHeader() {
		System.out.println(RESULT_HEADER);
	}

	public void showRoundResult(GameStatus gameStatus) {
		Map<String, Integer> roundStatus = gameStatus.getRoundStatus();
		for (String name : roundStatus.keySet()) {
			System.out.println(name + " : " + formatPositionToProgress(roundStatus.get(name)));
		}
		System.out.println();
	}

	private String formatPositionToProgress(int position) {
		StringBuilder progress = new StringBuilder();
		for (int i = 0; i < position; i++) {
			progress.append(ONE_STEP);
		}
		return progress.toString();
	}

	public void showWinners(String[] winnerNames) {
		String winnerNotice = "최종 우승자 : "
			+ String.join(", ", winnerNames);
		System.out.println(winnerNotice);
	}
}
