package model;

import java.util.ArrayList;

public class CarList {

	private ArrayList<Car> carList;

	public CarList(ArrayList<String> nameInput) {
		this.carList = new ArrayList<>();
		for (String eachName : nameInput) {
			this.carList.add(new Car(eachName));
		}
	}

	public void forwardAllCars(ArrayList<Integer> overThresholdIndexes) {
		for (int index : overThresholdIndexes) {
			this.carList.get(index).forwardCar();
		}
	}

	public int getMaxPostion() {
		int maxPosition = 0;
		for (Car eachCar : this.carList) {
			maxPosition = Math.max(maxPosition, eachCar.getCarPosition());
		}
		return maxPosition;
	}
}
