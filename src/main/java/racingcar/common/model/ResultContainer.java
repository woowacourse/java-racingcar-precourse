package racingcar.common.model;

import java.util.List;
import java.util.Map;

import racingcar.common.utils.StringUtil;
import racingcar.game.service.Result;

public class ResultContainer {
	public static void printRacingGameResult(final List<Result> result) {
		for (Result rs : result) {
			printCarStatus(rs);
		}

	}

	private static void printCarStatus(final Result result) {
		final Map<String, Integer> racingCarStatus = result.getCarStatus();

		racingCarStatus.forEach((name, position) ->
			System.out.println(name
				+ " : "
				+ StringUtil.convertIntoDashBy(position)));
		System.out.println();

	}

	public static void printWinners(final Result finalResult) {
		final String winners = StringUtil.joinNameOf(finalResult.getWinners());
		System.out.println(String.format("최종 우승자 : %s", winners));

	}

}
