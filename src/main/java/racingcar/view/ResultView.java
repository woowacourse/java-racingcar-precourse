package racingcar.view;

import java.util.Map;

import racingcar.domain.RoundStatus;

public class ResultView {
	private static final String RESULT_HEADER = "실행 결과";
	private static final String ONE_STEP = "-";

	public static void showResultHeader() {
		System.out.println(RESULT_HEADER);
	}

	public static void showRoundResult(RoundStatus roundStatus) {
		Map<String, Integer> roundStatusMap = roundStatus.getRoundStatus();
		for (String name : roundStatusMap.keySet()) {
			System.out.println(name + " : " + formatPositionToProgress(roundStatusMap.get(name)));
		}
		System.out.println();
	}

	private static String formatPositionToProgress(int position) {
		StringBuilder progress = new StringBuilder();
		for (int i = 0; i < position; i++) {
			progress.append(ONE_STEP);
		}
		return progress.toString();
	}

	public static void showWinners(String[] winnerNames) {
		String winnerNotice = "최종 우승자 : "
			+ String.join(", ", winnerNames);
		System.out.println(winnerNotice);
	}
}
