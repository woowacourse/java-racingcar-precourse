package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private static final String COLON = ": ";
	private static final String POSITION_MARK = "-";
	private static ArrayList<Car> carList;

	static ArrayList<Car> getCarListAfterRace() {
		return carList;
	}

	static void runRace(int numberOfRace, List<String> carNames) {
		carList = getReadyRacingCars(carNames);
		printRaceResultMessage();

		for (int i = 0; i < numberOfRace; i++) {
			isRacing(carList);
		}
	}

	private static ArrayList<Car> getReadyRacingCars(List<String> carNames) {
		ArrayList<Car> carList = new ArrayList<>(carNames.size());

		for (String carName : carNames) {
			Car car = new Car(carName);
			carList.add(car);
		}
		return carList;
	}

	private static void isRacing(ArrayList<Car> carList) {
		for (Car car : carList) {
			car.move();
			printPositions(car);
		}
		System.out.println();
	}

	private static void printPositions(Car car) {
		int position = car.getPosition();

		StringBuilder sb = new StringBuilder();
		sb.append(car.getName());
		sb.append(COLON);

		for (int i = 0; i < position; i++) {
			sb.append(POSITION_MARK);
		}
		System.out.println(sb.toString());
	}

	private static void printRaceResultMessage() {
		System.out.println("\n실행 결과");
	}

}
