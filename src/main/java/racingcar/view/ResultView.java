package racingcar.view;

import racingcar.domain.Rounds;

public class ResultView {

	private static final String WINNERS = "최종 우승자 : ";

	public static void printResultsByRound(Rounds rounds) {
		System.out.println(String.join("\n\n", rounds.getRoundResult()) + "\n");
	}

	public static void printWinners(Rounds rounds) {
		System.out.print(WINNERS);
		System.out.print(String.join(", ", rounds.getWinner()));
	}
}
