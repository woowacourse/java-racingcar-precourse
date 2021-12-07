package racingcar.domain;

import static racingcar.domain.constants.DomainConstants.*;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private static final List<String> winners = new ArrayList<>();

	public static void add(String winner) {
		winners.add(winner);
	}

	public static void print() {
		System.out.println(makeMessage());
	}

	private static String makeMessage() {
		StringBuilder builder = new StringBuilder(THE_WINNER_IS + winners.get(0));
		for (int i = 1; i < winners.size(); i++) {
			builder.append(", ").append(winners.get(i));
		}
		return builder.toString();
	}
}
