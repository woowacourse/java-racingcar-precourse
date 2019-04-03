/*
 * @(#) Game.java     1.0   2019/04/02
 *
 * Released under the MIT license
 */

package domain;

import err.NameRuleException;

import java.util.ArrayList;

/**
 * Game 클래스는 자동차경주 게임을 진행한다.
 *
 * @author 조남균
 * @version 1.00  2019년 04월 02일
 */
public class Game {
	private ArrayList<Car> cars;

	public void joinRace(String carNames, String delimiter) {
		this.cars = new ArrayList<Car>();

		for (String carName : carNames.split(delimiter)) {
			this.cars.add(new Car(carName));
		}
	}

	public void runLap() {
		for (Car car : this.cars) {
			car.tryMove();
		}
	}

	public ArrayList<Car> getCars() {
		return this.cars;
	}

	public ArrayList<String> getRaceChampion() {
		ArrayList<String> champions = new ArrayList<String>();
		int maxPosition = getMaxPosition();

		for (Car car : this.cars) {
			if (car.getPosition() == maxPosition) {
				champions.add(car.getName());
			}
		}
		return champions;
	}

	private int getMaxPosition() {
		int maxPosition = 0;

		for (Car car : this.cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}