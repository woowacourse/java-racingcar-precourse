package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	private int trialTime = 0;
	private List<Car> carList;
	private String winner = "";
	private InputManager inputManager;

	public RacingGame() {
		carList = new ArrayList<>();
		inputManager = new InputManager();
	}

	public void play() {
		prepareRacing();
		raceCars();
		showWinner();
	}

	/*
	 * 데이터를 입력받고, 경주를 위해 자동차 인스턴스를 생성하는 메서드
	 */
	private void prepareRacing() {
		inputManager.initialize();
		trialTime = inputManager.getTrialTime();
		for (String name : inputManager.getCarNames()) {
			carList.add(new Car(name));
		}
	}

	private void raceCars() {
		System.out.println("실행 결과");
		for (int i = 0; i < trialTime; i++) {
			for (Car car : carList) {
				car.goForwardOrNot();
				car.showPosition();
			}
			System.out.println();
		}
	}
	
	private void showWinner() {
		int MAX = 0;
		for (Car car : carList) {
			MAX = updateMAX(MAX, car);
			if (MAX == car.getPosition() && winner != car.getName()) {
				winner += ", " + car.getName();
			}
		}
		System.out.println(winner + "가 최종 우승했습니다.");
	}

	private int updateMAX(int MAX, Car car) {
		if (MAX < car.getPosition()) {
			winner = car.getName();
			return car.getPosition();
		}
		return MAX;
	}
}
