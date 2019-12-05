package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	/* 레이스 시도 횟수 */
	private int trialTime = 0;
	
	/* 경주에 참여하는 자동차 인스턴스를 저장하는 리스트 */
	private List<Car> carList;
	
	/* 우승자 이름을 저장 */
	private String winner = "";
	
	/* 유저로 부터 입력을 받기위한 InputManager 인스턴스 */
	private InputManager inputManager;

	public RacingGame() {
		carList = new ArrayList<>();
		inputManager = new InputManager();
	}

	/*
	 * game 전체 로직을 순차적으로 실행하는 메서드
	 * 데이터를 입력받고, 경주를 진행하고, 우승자를 결정한다.
	 */
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

	/*
	 * 매 시도 마다, Car객체에 메시지 전송하는 메서드
	 */
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
	
	/*
	 * 우승자를 계산해서 출력하는 메서드
	 * 가장 높은 position에 해당하는 carName을 출력한다.
	 */
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

	/*
	 * MAX값이 업데이트 되면 winner변수도 같이 업데이트시키는 메서드
	 */
	private int updateMAX(int MAX, Car car) {
		if (MAX < car.getPosition()) {
			winner = car.getName();
			return car.getPosition();
		}
		return MAX;
	}
	
}
