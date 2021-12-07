package racingcar.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
	private static final String RESULT_MESSAGE = "\n실행결과";

	public static void printWinners(Cars carList) {
		List<String> winnerList = carList.getWinner();
		String winnerMessage = "최종 우승자 : ";

		for (String winner : winnerList) {
			winnerMessage = winnerMessage.concat(winner);
			winnerMessage = winnerMessage.concat(", ");
		}
		System.out.print(winnerMessage.substring(0, winnerMessage.length() - 2));
	}

	public static void printFinalWinner(Cars carList) {
		printWinners(carList);
	}

	public static String getScoreString(Car drivingCar) {
		String unit = "-";
		Optional<String> result1 = Optional.empty();
		for (int count = 0; count <= drivingCar.getPosition().getPosition(); count++) {
			result1 = Stream.generate(() -> unit).limit(count).reduce((a, b) -> a + b);
		}
		String finalResult = "";
		if (result1.isPresent()) {
			finalResult = result1.get();
		}
		return finalResult;
	}

	public static void printScoreOfOneStep(List<Car> carList) {
		for (Car car : carList) {
			printScoreOfCar(car);
		}
		System.out.println();
	}

	public static void printScoreOfCar(Car drivingCar) {
		System.out.println(drivingCar.getName() + " : " + OutputView.getScoreString(drivingCar));

	}

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}
}
