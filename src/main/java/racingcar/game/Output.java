package racingcar.game;

import static racingcar.constant.Constant.*;
import static racingcar.constant.Message.*;

import java.util.List;

import racingcar.car.Car;

public class Output {
	public void printWinners(List<String> winnersNameList) {
		System.out.print(WINNER_RESULT);
		System.out.print(winnersNameList.get(0));
		if (winnersNameList.size() == 1) {
			return;
		}
		for (int i = 1; i < winnersNameList.size(); i++) {
			System.out.print(", " + winnersNameList.get(i));
		}
	}

	public void printCarInfo(List<Car> carList) {
		carList.forEach(car -> {
			// 차 이름 출력
			System.out.print(car.getName() + " : ");
			// 차 position 출력
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print(PRINTOR);
			}
			// 줄바꿈
			System.out.println();
		});
	}
}
