package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;
	private int highScore;

	public Cars(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		this.cars = cars;
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<List<String>> getRoundResult() {
		List<List<String>> totalResult = new ArrayList<>();
		for (Car car : cars) {
			List<String> result = car.getResult();
			totalResult.add(result);
		}
		return totalResult;
	}

	public List<String> getChampionList() {
		getHighScore();
		List<String> champion = new ArrayList<>();
		for (Car car : cars) {
			car.isChampion(champion, highScore);
		}
		return champion;
	}

	private void getHighScore() {
		for (Car car : cars) {
			highScore = car.updateHighScore(highScore);
		}
	}
}
