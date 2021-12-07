package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;
import racingcar.umpire.Umpire;

public class Game {
	public int num;
	public List<Car> carList;
	public Umpire umpire;

	public Game() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] names = readLine().split(",");
		carList = makeCarList(names);

		System.out.println("시도할 회수는 몇회인가요?");
		num = inputNum();

		umpire = new Umpire(carList);
	}

	public void gameStart() {
		System.out.println("실행 결과");
		for (int i = 0; i < num; i++) {
			playGames();
		}
	}

	private void playGames() {
		moveCarList();
		printCarInfo();
	}

	private void moveCarList() {
		carList.forEach(car -> {
			car.move();
		});
	}

	private void printCarInfo() {
		carList.forEach(car -> {
			// 차 이름 출력
			System.out.print(car.getName() + " : ");
			// 차 position 출력
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}
			// 줄바꿈
			System.out.println();
		});
	}

	private int inputNum() {
		int num;

		try {
			num = Integer.parseInt(readLine());
		} catch (Exception e) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.\n");
			num = inputNum();
		}

		return num;
	}

	private List<Car> makeCarList(String[] names) {
		List<Car> carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}
		return carList;
	}
}
