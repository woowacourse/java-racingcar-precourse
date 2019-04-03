/*
 *  클래스 이름 : CarGame.java
 *
 *  버전 정보 : 1.0.0
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
	private int tryCount;
	static final String RESULT_TITLE = "실행결과";
	static final String RESULT_MESSAGE = "가 최종우승했습니다.";
	static final int CAR_MOVE_CONDITION = 4;

	public CarGame(UserInput userInput) {
		racingCarList = createRacingCarList(userInput.getRacingCarName());
		this.tryCount = userInput.getTryCount();
	}

	public List<Car> createRacingCarList(String[] racingCarNameList) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < racingCarNameList.length; ++i) {
			carList.add(new Car(racingCarNameList[i]));
		}
		return carList;
	}

	public void playGame() {
		System.out.println("\n"+RESULT_TITLE);

		while (tryCount-- > 0) {
			for (int i = 0; i < racingCarList.size(); ++i) {
				goOrNotCar(racingCarList.get(i));
				printCarPosition(racingCarList.get(i));
			}
			System.out.println();
		}

		printWinner(getWinner());
	}

	public void goOrNotCar(Car car) {
		RandomNumber randomNumber = new RandomNumber();
		if (randomNumber.getRandomNumber() >= CAR_MOVE_CONDITION) {
			car.moveCar();
		}
	}

	public void printCarPosition(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); ++i) {
			System.out.print("-");
		}
		System.out.println();
	}

	public int getCarsMaxPosition() {
		int carMaxPosition = 0;

		for (int i = 0; i < racingCarList.size(); ++i) {
			carMaxPosition = Math.max(carMaxPosition, racingCarList.get(i).getPosition());
		}

		return carMaxPosition;
	}

	public List<String> getWinner() {
		List<String> winnerList = new ArrayList<>();
		int maxPosition = getCarsMaxPosition();

		for (int i = 0; i < racingCarList.size(); ++i) {
			if (racingCarList.get(i).getPosition() == maxPosition) {
				winnerList.add(racingCarList.get(i).getName());
			}
		}

		return winnerList;
	}

	public void printWinner(List<String> winnerList) {
		for (int i = 0; i < winnerList.size(); ++i) {
			System.out.print(winnerList.get(i));
			if (i != winnerList.size() - 1) {
				System.out.print(", ");
			}
		}

		System.out.println(RESULT_MESSAGE);
	}

}
