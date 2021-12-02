package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class GameMachine {

	private List<Car> cars;
	private int round;

	public GameMachine() {
		this.cars = new ArrayList<>();
	}

	public void racingGame() {
		lineUp();
	}

	public void lineUp() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();
		String[] names = userInput.split(",");
		for (String name : names) {
			cars.add(new Car(name.trim()));
		}
	}
}
