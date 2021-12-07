package racingcar.service;

import java.util.ArrayList;

import racingcar.domain.Car;

public class JudgingService {

	public ArrayList<String> judge(ArrayList<Car> carList) {
		ArrayList<String> winnerList = new ArrayList<>();

		int maxDriveLength = getMaxDriveLength(carList);

		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);

			if (car.showPosition().length() == maxDriveLength) {
				winnerList.add(car.getName());
			}
		}

		return winnerList;
	}

	private int getMaxDriveLength(ArrayList<Car> carList) {
		int max = carList.stream()
			.map(car -> car.showPosition().length())
			.mapToInt(length -> Integer.valueOf(length))
			.max()
			.getAsInt();

		return max;
	}
}
