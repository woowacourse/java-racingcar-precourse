package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import racingcar.view.InputView;

public class RacingGame {
	private ArrayList<Car> everyCar = new ArrayList<>(); // TODO: 1급 콜렉션으로 만들기

	public void startGame() {
		String[] everyCarName = InputView.enterEveryCarName();
		Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));
		makeEveryCarInstance(everyCarName);
		int tryCntAboutCarMoving = InputView.enterTryCnt();
		System.out.println("실행 결과");
		for (int i = 0; i < tryCntAboutCarMoving; i++) {
			moveEveryCarThisTiming(everyCar);
		}
		everyCar.stream().forEach(car -> System.out.println(car+"의 자동차는" + car.moveThisDistance()));
	}

	private void makeEveryCarInstance(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> everyCar.add(new Car(eachCarName)));
	}

	private void moveEveryCarThisTiming(ArrayList<Car> everyCar) {
		everyCar.stream().forEach(eachCar -> eachCar.move());
		showTheResultThisTiming();
	}

	private void showTheResultThisTiming() {
		everyCar.stream().forEach(eachCar -> System.out.println(String.format("%s : %s", eachCar, eachCar.showMovingMark())));
		System.out.println();
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
