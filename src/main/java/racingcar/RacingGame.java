package racingcar;

import java.util.ArrayList;

/**
 * 자동차 경주 게임 객체 생성을 위한 클래스
 * 기능 1. 자동차 경주 게임 싱글톤 객체 반환
 * 기능 2. Car 리스트에 이름으로 새로운 Car 객체 추가
 * 기능 3. Car 리스트 초기화
 */
public class RacingGame {
	private static RacingGame racingGame = new RacingGame();

	private ArrayList<Car> cars = new ArrayList<Car>();

	private RacingGame() {
	}

	public static RacingGame getInstance() {
		return racingGame;
	}

	public void addCarByName(String name) {
		cars.add(new Car(name));
	}

	public void clearCars() {
		cars = new ArrayList<Car>();
	}
}
