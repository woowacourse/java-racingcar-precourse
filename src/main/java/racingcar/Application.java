package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;

public class Application {
	private static int racingCnt;
	private static List<String> carNames;

	private static CarService carService = new CarServiceImpl();

	public static void main(String[] args) {
		// TODO 구현 진행
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		inputCarNames();
		joinCars();
		System.out.println("시도할 회수는 몇회인가요?");
		inputRacingCnt();
		System.out.println();
		System.out.println("실행 결과");
		racing();
		System.out.print("최종 우승자 : ");
		printResult();
	}

	public static void inputCarNames() {
		try {
			String[] inputNames = Console.readLine().split(",");
			carNames = new ArrayList<>();
			for (String carName : inputNames) {
				carNames.add(carName);
				isLengthLessThanOrEqualFive(carName);
				isDuplicateName(carName);
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			inputCarNames();
		}
	}

	public static void joinCars() {
		for (String carName : carNames) {
			carService.join(carName);
		}
	}

	public static void inputRacingCnt() {
		try {
			String inputNumber = Console.readLine();
			isZeroOrPositiveNumber(inputNumber);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			inputRacingCnt();
		}
	}

	public static void racing() {
		for (int i = 0; i < racingCnt; i++) {
			carService.moveAllCars();
		}
	}

	public static void printResult() {
		List<Car> winningCars = carService.findWinningCars();
		int winningCarsCnt = winningCars.size();
		if (winningCarsCnt == 1) {
			System.out.println(winningCars.get(0).getName());
			return;
		}
		for (int i = 0; i < winningCarsCnt - 1; i++) {
			System.out.print(winningCars.get(i).getName() + ", ");
		}
		System.out.println(winningCars.get(winningCarsCnt - 1).getName());
	}

	public static void isLengthLessThanOrEqualFive(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
		}
	}

	public static void isZeroOrPositiveNumber(String number) {
		try {
			racingCnt = Integer.parseInt(number);
			if (racingCnt < 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 음이 아닌 숫자여야 한다.");
		}
	}

	public static void isDuplicateName(String name) {
		if (carNames.indexOf(name) != carNames.lastIndexOf(name)) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복되지 않아야 한다.");
		}
	}
}
