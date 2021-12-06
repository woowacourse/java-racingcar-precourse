package racingcar;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OutputHandler {
	
	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printBlankLine() {
		System.out.println();
	}

	public void printErrorMessage(Exception exception) {
		System.out.println(exception.getMessage());
	}

	public void printTurnStatus(List<Car> carList) {
		for (Car car : carList) {
			Optional<String> result = Stream.generate(() -> "-").limit(car.getPosition()).reduce((a, b) -> a + b);
			String carPosition = "";
			if (result.isPresent()) {
				carPosition = result.get();
			}
			printMessage(String.format(GameData.RESULT_FORMAT, car.getName(), carPosition));
		}
		printBlankLine();
	}

	public void printWinner(List<Car> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car winner : winnerList) {
			if (stringBuilder.length() != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(winner.getName());
		}
		printMessage(GameData.WINNER_MESSAGE + stringBuilder.toString());
	}
}
