package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class CarList {
	private final ArrayList<Car> cars = new ArrayList<>();

	public CarList(String [] carNames){
		for (String carName : carNames) {
			this.cars.add(new Car(carName));
		}
	}

	private void moveCars() {
		for (Car car : this.cars) {
			if (Randoms.pickNumberInRange(0, 9) >= 4)
				car.moveForward();
		}
	}
}
