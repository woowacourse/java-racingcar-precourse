package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class GameMachine {
	public static final int ZERO = 0;

	private int round;
	private final List<Car> cars;

	public GameMachine() {
		this.cars = new ArrayList<>();
	}

	public void racingGame() {
		lineUp();
		inputRound();
		raceStart(this.round);
		awards();
	}

	public void lineUp() {
		String userInput;
		String[] names;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			userInput = Console.readLine();
			names = userInput.split(",");
		} while (!Validator.checkNames(names));
		for (String name : names) {
			cars.add(new Car(name.trim()));
		}
	}

	public void inputRound() {
		String userInput;
		do {
			System.out.println("시도할 횟수는 몇회인가요?");
			userInput = Console.readLine();
		} while (!Validator.checkRound(userInput));
		this.round = Integer.parseInt(userInput);
	}

	public void raceStart(int round) {
		System.out.println("실행 결과");
		while (round > ZERO) {
			for (Car car : this.cars) {
				car.move();
				car.statusReport();
			}
			System.out.println();
			round--;
		}
	}

	public void awards() {
		List<String> winners = new ArrayList<>();
		int maxPosition = findMaxPosition();
		for (Car car : this.cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}

	public int findMaxPosition() {
		int maxPosition = ZERO;
		for (Car car : this.cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
