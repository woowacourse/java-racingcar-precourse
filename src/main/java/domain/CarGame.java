/*
 *  클래스 이름 : CarGame.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-31
 *
 *  저작권 : 이예지
 */

package domain;

import utils.RandomNumber;

import java.util.*;

public class CarGame {

	private List<Car> racingCarList;
	private int carMoveCount;
	private StringBuilder stringBuilder;

	public CarGame(String[] racingCarLIst, int carMoveCount) {

		racingCarList = new ArrayList<>();
		Arrays.stream(racingCarLIst).forEach(s -> this.racingCarList.add(new Car(s)));
		this.carMoveCount = carMoveCount;

	}

	public void playGame() {

		RandomNumber randomNumber = new RandomNumber();
		int moveCount;
		stringBuilder = new StringBuilder();

		stringBuilder.append("\n실행결과\n");

		while (carMoveCount-- > 0) {
			for (int i = 0; i < racingCarList.size(); ++i) {
				moveCount = racingCarList.get(i).moveCar(randomNumber);
				printCarMoveCount(racingCarList.get(i), moveCount);
			}
			stringBuilder.append("\n");
		}

		System.out.println(stringBuilder);
		stringBuilder.delete(0, stringBuilder.length());
		printWinner(getWinner());
	}

	public void printCarMoveCount(Car car, int moveCount) {

		stringBuilder.append(car.getName() + " : ");
		for (int i = 0; i < moveCount; ++i) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");

	}

	public List<String> getWinner() {
		List<String> winnerList = new ArrayList<>();
		int maxCount = 0;

		for (int i = 0; i < racingCarList.size(); ++i) {
			maxCount = Math.max(maxCount, racingCarList.get(i).getPosition());
		}

		for (int i = 0; i < racingCarList.size(); ++i) {
			if (racingCarList.get(i).getPosition() == maxCount) {
				winnerList.add(racingCarList.get(i).getName());
			}
		}

		return winnerList;
	}

	public void printWinner(List<String> winnerList) {

		for (int i = 0; i < winnerList.size(); ++i) {
			stringBuilder.append(winnerList.get(i));
			if (i != winnerList.size() - 1) {
				stringBuilder.append(", ");
			}
		}

		stringBuilder.append("가 최종우승했습니다.");

		System.out.println(stringBuilder);
	}

}
