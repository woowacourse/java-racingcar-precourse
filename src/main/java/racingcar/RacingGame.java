package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import racingcar.view.InputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>(); // TODO: 1급 콜렉션으로 만들기
	private EveryCar everyCar;
	public void startGame() {
		String[] everyCarName = InputView.enterEveryCarName();
		Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));
		makeEveryCarInstance(everyCarName);
		everyCar = new EveryCar(cars);
		int tryCntAboutCarMoving = InputView.enterTryCnt();
		System.out.println("실행 결과");
		for (int i = 0; i < tryCntAboutCarMoving; i++) {
			everyCar.moveEveryCarThisTiming();
		}
		//everyCar의 eachCar. eachCar의 position이 가장 큰게 뭘까? 그리고 그 큰 값과 동일한 애들 전부 가져와서 이름을 보여주기.
		everyCar.showThisGameWinner();
	}

	private void makeEveryCarInstance(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> cars.add(new Car(eachCarName)));
	}

	private void validateCarName(String eachCarName) { // TODO: 이 로직은 INputView 로 옮기는게 적절할거같음.
		if (eachCarName.length() > 5) {
			throw new IllegalArgumentException("차 이름이 5글자가 넘어감.");
		}
		if (eachCarName.isEmpty()) {
			throw new IllegalArgumentException("차 이름 중 null값 있음");
		}
	}

}
