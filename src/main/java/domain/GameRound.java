/*
 * GameRound.java
 */

package domain;

import java.util.ArrayList;
import java.util.List;

class GameRound {

	List<Car> carList;

	public GameRound(List<Car> carList) {
		this.carList = carList;
	}

	public void proceed() {
		for (Car car : this.carList) {
			car.moveCar();
		}
	}

	public void printGameRounds() {
		for (Car car : this.carList) {
			printGameRound(car);
		}
	}

	private void printGameRound(Car car) {
		String lines = positionToLine(car.getPosition());
		System.out.println(car.getName() + " : " + lines);
	}

	private String positionToLine(int position) {
		// position => "----"
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < position; i++) {
			resultString.append("-");
		}
		return resultString.toString();
	}

	public String getWinnerString() {
		StringBuilder winners = new StringBuilder();
		List<String> winnerList = getWinnerList();
		for (String s : winnerList) {
			winners.append(s + ", ");
		}
		winners.delete(winners.lastIndexOf(", "), winners.length());
		return winners.toString();
	}

	private List<String> getWinnerList() {
		List<String> ret = new ArrayList<String>();
		int winPosition = getWinnerPosition();
		for (Car car : this.carList) {
			if (car.getPosition() == winPosition) {
				ret.add(car.getName());
			}
		}
		return ret;
	}

	private int getWinnerPosition() {
		int winner = carList.get(0).getPosition();
		for (int i = 1; i < this.carList.size(); i++) {
			int cur = this.carList.get(i).getPosition();
			if (cur > winner) {
				winner = cur;
			}
		}
		return winner;
	}
}
