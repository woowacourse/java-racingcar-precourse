/*
 * GameRound.java
 */

package domain;

import java.util.List;

public class GameRound {

	List<Car> cars;

	public GameRound(List<Car> cars) {
		this.cars = cars;
	}

	public void proceed() {
		for (Car car : cars) {
			car.moveCar();
		}
	}

	public void printGameRounds() {
		for (Car car : cars) {
			printGameRound(car);
		}
	}

	private void printGameRound(Car car) {
		String lines = positionToLine(car.getPosition());
		System.out.println(car.getName() + " : " + lines);
	}

	private String positionToLine(int position) {
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < position; i++) {
			resultString.append("-");
		}
		return resultString.toString();
	}
}
