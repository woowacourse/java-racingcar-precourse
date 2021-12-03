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
		Car winner = participantCars.get(0);
		this.winners = participantCars.stream()
			.filter(car -> car.compareTo(winner) == 0)
			.collect(Collectors.toList());
	}

	private void printWinners() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(MESSAGE_PRINT_WINNERS);
		for (int i = 0; i < winners.size(); i++) {
			stringBuilder.append(winners.get(i).getName()).append(MESSAGE_COMMA_WITH_SPACE);
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
		System.out.println(stringBuilder);
	}
}
