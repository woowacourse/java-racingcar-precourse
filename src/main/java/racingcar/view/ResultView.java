package racingcar.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Result;
import racingcar.domain.Round;

public class ResultView {

	private static final String ROUND_RESULT = "실행 결과";
	private static final String RESULT = "-";
	private static final String WINNERS = "최종 우승자 : ";

	public static void printResultsByRound(List<Round> rounds) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(ROUND_RESULT).append("\n");
		rounds.stream()
			.map(Round::getRoundResult)
			.forEach(
				results -> {
					results.forEach(
						result ->
							sb.append(result.getCarName()).append(" : ").append(String.join("",
								Collections.nCopies(result.getCarPosition(), RESULT))).append("\n"));
					sb.append("\n");
				}
			);
		System.out.print(sb);
	}

	public static void printWinners(List<Result> winners) {
		System.out.print(WINNERS + winners.stream().map(Result::getCarName).collect(Collectors.joining(", ")));
	}

}
