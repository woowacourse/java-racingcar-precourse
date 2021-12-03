package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;

public class Application {
	private static List<Car> winningCars;

	private static CarService carService = new CarServiceImpl();

	public static void main(String[] args) {
		// TODO 구현 진행
		inputCars();
		racing();
		printResult();
	}

	public static void inputCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] cars = Console.readLine().split(",");

		for (String carName : cars) {
			carService.join(carName);
		}
	}

	public static void racing() {
		System.out.println("시도할 회수는 몇회인가요?");
		int racingCnt = Integer.parseInt(Console.readLine());
		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < racingCnt; i++) {
			carService.moveAllCars();
		}
	}

	public static void printResult() {
		List<Car> winningCars = carService.findWinningCars();
		int winningCarsCnt = winningCars.size();
		System.out.print("최종 우승자 : ");
		if (winningCarsCnt == 1) {
			System.out.println(winningCars.get(0).getName());
			return;
		}
		for (int i = 0; i < winningCarsCnt - 1; i++) {
			System.out.print(winningCars.get(i).getName() + ", ");
		}
		System.out.println(winningCars.get(winningCarsCnt - 1).getName());
	}

}
