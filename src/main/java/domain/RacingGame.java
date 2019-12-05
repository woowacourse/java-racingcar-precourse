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
}
