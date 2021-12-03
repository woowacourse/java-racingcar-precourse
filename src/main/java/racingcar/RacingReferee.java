package racingcar;

import static racingcar.util.Constants.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingReferee {
	private List<Car> winners;

	public void showWinners(List<Car> participantCars) {
		findWinner(participantCars);
		printWinners();
	}

	private void findWinner(List<Car> participantCars) {
		Collections.sort(participantCars);
		Car winner = participantCars.get(WINNER_INDEX);
		this.winners = participantCars.stream()
			.filter(car -> car.compareTo(winner) == COMPARE_WINNER_RESULT)
			.collect(Collectors.toList());
	}

	private void printWinners() {
		StringBuilder builder = new StringBuilder();
		builder.append(MESSAGE_PRINT_WINNERS);
		for (int i = 0; i < winners.size(); i++) {
			builder.append(winners.get(i).getName()).append(MESSAGE_COMMA_WITH_SPACE);
		}
		builder.delete(builder.length() - DELETE_STRING_COMMA, builder.length() - DELETE_STRING_END);
		System.out.println(builder);
	}
}
