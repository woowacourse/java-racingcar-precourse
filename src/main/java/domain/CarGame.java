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

	}

	public void printCarMoveCount(Car car, int moveCount) {

		stringBuilder.append(car.getName() + " : ");
		for (int i = 0; i < moveCount; ++i) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");

	}

}
