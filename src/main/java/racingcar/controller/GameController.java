package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.view.ResultView;
import racingcar.view.UserView;

/*
 * 게임 구현
 * */
public class GameController {
	private static final String PLAY_RESULT_MESSAGE = "실행 결과";

	private static List<Car> carList;

	public GameController() {
		carList = new ArrayList<>();
	}

	public void run() {
		this.getCarNameList();
		int totalRounds = UserView.setRoundInput();
		this.play(totalRounds);
		ResultView.printWinners(carList);
	}

	private void getCarNameList() {
		String[] carNames = UserView.setCarNamesInput();
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	private void play(int totalRounds) {
		System.out.println(PLAY_RESULT_MESSAGE);

		for (int i = 0; i < totalRounds; i++) {
			for (Car car : carList) {
				car.playRound();
			}
			ResultView.printPosition(carList);
			System.out.println();
		}
	}
}
