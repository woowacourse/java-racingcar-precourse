/*
 * GameRound.java
 */

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class GameRound {

	List<Car> carList;

	public GameRound(List<Car> carList) {
		this.carList = carList;
	}

	public void proceed() {
		for (Car car : this.carList) {
			car.moveCar(getRandomNumber());
		}
	}

	private int getRandomNumber() {
		Random randomNumberMaker = new Random();
		int randomNumber = randomNumberMaker.nextInt(10);
		return randomNumber;
	}

	public void printOneRound() {
		for (Car car : this.carList) {
			printCarPosition(car);
		}
	}

	private void printCarPosition(Car car) {
		String lines = positionToLine(car.getPosition());
		System.out.println(car.getName() + " : " + lines);
	}

	private String positionToLine(int position) {
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < position; i++) {
			resultString.append("-");
		}
		return resultString.toString();
	}

	public String getWinnerString() {
		StringBuilder winners = new StringBuilder();
		List<String> winnerList = getWinnerCars();
		for (String s : winnerList) {
			winners.append(s);
		}
		return winners.toString();
	}

	private List<String> getWinnerCars() {
		List<String> ret = new ArrayList<String>();
		int winPosition = getWinnerPosition();
		for (Car car : this.carList) {
			if (car.getPosition() == winPosition) {
				ret.add(car.getName());
				ret.add(",");
			}
		}
		ret.remove(ret.size() - 1);
		return ret;
	}

	private int getWinnerPosition() {
		int winnerPos = carList.get(0).getPosition();
		for (int i = 1; i < this.carList.size(); i++) {
			int curPos = this.carList.get(i).getPosition();
			if (curPos > winnerPos) {
				winnerPos = curPos;
			}
		}
		return winnerPos;
	}
}
