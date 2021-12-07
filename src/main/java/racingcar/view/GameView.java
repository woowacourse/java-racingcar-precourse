package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class GameView {
	public static void playUI() {
		System.out.println("실행 결과");
	}

	public static void resultUI(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + " : " + formatPosition(car.getPosition()));
		}
		System.out.println();
	}

	public static void winnersUI(List<Car> winners) {
		System.out.println("최종 우승자 : " + formatWinners(winners));
	}

	private static String formatPosition(int position) {
		return new String(new char[position]).replace("\0", "-");
	}
	
	private static String formatWinners(List<Car> winners) {
		String result = winners.remove(0).getName();
		for (Car car : winners) {
			result += ", " + car.getName();
		}
		return result;
	}
}
