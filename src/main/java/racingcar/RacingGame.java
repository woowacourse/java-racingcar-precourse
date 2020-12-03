package racingcar;

import java.util.ArrayList;

import utils.RandomUtils;

/**
 * 자동차 경주 게임 객체 생성을 위한 클래스 기능
 * 1. 자동차 경주 게임 싱글톤 객체 반환 기능
 * 2. Car 리스트에 이름으로 새로운 Car 객체 추가 기능
 * 3. Car 리스트 초기화 기능
 * 4. Car 리스트의 Car 객체들이 모두 랜덤한 숫자를 기준으로 전진하거나 멈춰있는 기능
 */
public class RacingGame {
	private static final Integer MAX_RANDOM_NUM = 9;
	private static final Integer MIN_RANDOM_NUM = 0;
	private static final Integer MOVE_CRITERIA_NUM = 4;

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

	public void playOnePeriod() {
		for (Car car : cars) {
			int randNum = RandomUtils.nextInt(MAX_RANDOM_NUM, MIN_RANDOM_NUM);
			if (randNum >= MOVE_CRITERIA_NUM) {
				car.moveForwardByOne();
			}
		}
	}
}
