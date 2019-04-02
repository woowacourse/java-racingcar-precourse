package domain;

import java.util.ArrayList;

public class Game {
	private ArrayList<Car> cars;

	public Game() {
		this.cars = new ArrayList<Car>();
	}

	public void joinRace(String carNames) {
		String req = ",";
		for (String carName : carNames.split(req)) {
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
}
