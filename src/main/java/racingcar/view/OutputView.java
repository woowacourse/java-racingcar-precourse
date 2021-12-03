package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	public void printResults(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

	public void printWinners(List<Car> winners) {
		System.out.print("최종 우승자: ");
		System.out.print(winners.get(0).getName());
		if (winners.size() == 1) {
			System.out.println();
			return;
		}
		for (int i = 1; i < winners.size(); i++) {
			System.out.print(", " + winners.get(i).getName());
		}
		System.out.println();
	}
}
