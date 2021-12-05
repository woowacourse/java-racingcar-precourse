package racingcar.domain;

import java.util.ArrayList;

public class Cars {

	private ArrayList<Car> carArrayList;
	private int repeatNum;

	public Cars() {
		this.carArrayList = new ArrayList<>();
		this.repeatNum = 0;
	}

	public void addCarInList(String car) {
		carArrayList.add(new Car(car));
	}

	public void setRepeatNum(int repeatNum) {
		this.repeatNum = repeatNum;
	}

	public ArrayList<Car> getCarArrayList() {
		return carArrayList;
	}

	public int getRepeatNum() {
		return repeatNum;
	}
}
