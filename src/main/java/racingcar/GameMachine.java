package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameMachine {
	private int round;

	private List<Car> cars;

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
		while (round > 0) {
			for (Car car : this.cars) {
				car.move();
				car.statusReport();
			}
			System.out.println();
			round--;
		}
	}

	public void awards() {
		List<Car> winners = new ArrayList<>();
		int maxPosition = findMaxPosition();
		StringBuffer winnerMSG = new StringBuffer("최종 우승자 : ");
		for (Car car : this.cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}
		for (Car car : winners) {
			winnerMSG.append(car.getName());
			winnerMSG.append(", ");
		}
		System.out.println(winnerMSG.substring(0, winnerMSG.length() - 2));
	}

	public int findMaxPosition() {
		int maxPosition = 0;
		for (Car car : this.cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
