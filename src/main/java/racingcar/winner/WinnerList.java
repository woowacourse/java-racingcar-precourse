package racingcar.winner;

import java.util.ArrayList;

import racingcar.car.Car;

public class WinnerList {
	private int winnerPosition;
	private ArrayList<Car> winnerCarList = new ArrayList<>();

	public int getWinnerPosition() {
		return winnerPosition;
	}

	public void setWinnerPosition(int winnerPosition) {
		this.winnerPosition = winnerPosition;
	}

	public ArrayList<Car> getWinnerCarList() {
		return winnerCarList;
	}

	public void addWinnerCarList(Car winnerCar) {
		this.winnerCarList.add(winnerCar);
	}
}
