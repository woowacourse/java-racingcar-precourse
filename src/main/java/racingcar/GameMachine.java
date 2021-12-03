package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameMachine {

	private List<Car> cars;
	private int round;

	public GameMachine() {
		this.cars = new ArrayList<>();
	}

	public void racingGame() {
		lineUp();
		inputRound();
		raceStart(this.round);
	}

	public void lineUp() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();
		String[] names = userInput.split(",");
		//null, 중복 이름 검사 추가 예정
		for (String name : names) {
			cars.add(new Car(name.trim()));
		}
	}

	public void inputRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String userInput = Console.readLine();
		//숫자인지, 1보다 큰지 유효성 검사 추가 예정
		this.round = Integer.parseInt(userInput);
	}

	public void raceStart(int round) {
		System.out.println("실행 결과");
		while (round > 0) {
			for (Car car : cars) {
				car.move();
				car.statusReport();
			}
			System.out.println();
			round--;
		}
	}
}
