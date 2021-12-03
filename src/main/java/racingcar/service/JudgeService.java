package racingcar.service;

import java.util.ArrayList;

import racingcar.Car;

public class JudgeService {

	public ArrayList<String> makeWinnerList(ArrayList<Car> carList) {
		ArrayList<String> winnerList = new ArrayList<>();

		int max = carList.stream()
			.map(car -> car.showPosition().length())
			.mapToInt(length -> Integer.valueOf(length))
			.max()
			.getAsInt();

		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);

			if (car.showPosition().length() == max) {
				winnerList.add(car.getName());
			}
		}

		return winnerList;
	}
}
