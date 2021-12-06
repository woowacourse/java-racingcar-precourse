package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> carList;
	private int repeatNumber;

	public Cars() {
		this.carList = new ArrayList<>();
		this.repeatNumber = 0;
	}

	public void addCarInList(String car) {
		carList.add(new Car(car));
	}

	public void setRepeatNumber(int repeatNumber) {
		this.repeatNumber = repeatNumber;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int getRepeatNumber() {
		return repeatNumber;
	}
}
