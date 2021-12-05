package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Cars {

	private static final String OUTPUT_FINAL_WINNERS = "최종 우승자 : ";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public void move() {
		cars.forEach(car -> car.move(new RandomMovingStrategy()));
	}

	public void printPosition() {
		cars.forEach(car -> car.printPosition());
		System.out.println();
	}

	public boolean isEndGame(int tryNumber) {
		return cars.stream()
			.anyMatch(car -> car.isEndGame(tryNumber));
	}

	public void printWinners(int tryNumber) {
		List<Car> winners = getWinners(tryNumber);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(OUTPUT_FINAL_WINNERS);
		String winnersString = winners.stream()
			.map(car -> car.getName())
			.collect(Collectors.joining(", "));
		stringBuffer.append(winnersString);
		System.out.println(stringBuffer);
	}

	private List<Car> getWinners(int tryNumber) {
		return cars.stream().filter(car -> car.isEndGame(tryNumber)).collect(Collectors.toList());
	}
}
