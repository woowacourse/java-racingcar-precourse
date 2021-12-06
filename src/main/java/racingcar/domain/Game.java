package racingcar.domain;

import racingcar.view.OutputView;

public class Game {
	public Cars carList;

	public Game(Cars carList) {
		this.carList = carList;
	}

	private void runGameByCar(Car drivingCar) {
		int randomNo = new GenerateRandomNo().randomNo;
		if (Car.isForward(randomNo)) {
			drivingCar.forward();
		}
	}

	public void runGameOneStep() {
		for (Car car : this.carList.getCars()) {
			runGameByCar(car);
		}
	}

	public Cars getCarList() {
		return this.carList;
	}
}
