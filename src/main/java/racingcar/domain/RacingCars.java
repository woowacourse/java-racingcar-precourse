package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
	private final List<Car> cars;

	public RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	public void go() {
		cars.forEach(Car::go);
	}

	public String[] getNames() {
		String[] names = new String[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
			names[i] = cars.get(i).getName();
		}
		return names;
	}

	public int[] getPositions() {
		int[] positions = new int[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
			positions[i] = cars.get(i).getPosition();
		}
		return positions;
	}

	public List<String> getWinners() {
		int maxStep = searchMaxStep();

		return cars.stream().filter(car -> car.getPosition() == maxStep)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int searchMaxStep() {
		int[] positions = getPositions();
		int max = 0;

		for (int position : positions) {
			if (position > max) {
				max = position;
			}
		}
		return max;
	}
}
