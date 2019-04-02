package domain;

import java.util.ArrayList;

public class Game {
	private ArrayList<Car> cars;

	public void joinRace(String carNames) throws Exception {
		this.cars = new ArrayList<Car>();
		Exception errCarName = new Exception("이름이 5자 초과");
		String req = ",";

		for (String carName : carNames.split(req)) {
			if (carName.length() > 5) {
				throw errCarName;
			}
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
