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

	public int getMaxPosition() {
		int maxPosition = 0;
		for (Car eachCar : this.carList) {
			maxPosition = Math.max(maxPosition, eachCar.getCarPosition());
		}
		return maxPosition;
	}

	public ArrayList<Integer> getAllPosition() {
		ArrayList<Integer> allPosition = new ArrayList<>();
		for (Car eachCar : this.carList) {
			allPosition.add(eachCar.getCarPosition());
		}
		return allPosition;
	}

	public ArrayList<String> getWinnerName() {
		int maxPosition = this.getMaxPosition();
		ArrayList<String> winnerName = new ArrayList<>();
		for (Car eachCar : this.carList) {
			if (eachCar.isWinner(maxPosition)) {
				winnerName.add(eachCar.getCarName());
			}
		}
		return winnerName;
	}
}
