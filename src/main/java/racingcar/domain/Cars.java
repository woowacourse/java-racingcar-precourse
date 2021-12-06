package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> carList;
	private int repeatNum;

	public Cars() {
		this.carList = new ArrayList<>();
		this.repeatNum = 0;
	}

	public void addCarInList(String car) {
		carList.add(new Car(car));
	}

	public void setRepeatNum(int repeatNum) {
		this.repeatNum = repeatNum;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int getRepeatNum() {
		return repeatNum;
	}
}
