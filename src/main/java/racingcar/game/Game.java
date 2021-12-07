package racingcar.game;

import static racingcar.constant.Message.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;
import racingcar.umpire.Umpire;

public class Game {
	public int num;
	public List<Car> carList;
	public Umpire umpire;
	public Input input;
	public Output output;

	public Game() {
		input = new Input();
		// 자동차 이름 입력
		String[] names = input.inputNames();
		carList = makeCarList(names);
		// 시도 횟수 입력
		num = input.inputNum();
		System.out.println();
		// 결과 판단 클래스 호출
		umpire = new Umpire(carList);
		output = new Output();
	}

	public void start() {
		System.out.println(RESULT);
		// 시도회수만큼 게임 실행
		for (int i = 0; i < num; i++) {
			playGames();
			System.out.println();
		}
	}

	// 게임이 끝나고 결과를 보여준다
	public void end() {
		umpire.getWinner();
		output.printWinners(umpire.getWinnersNameList());
	}

	private void playGames() {
		moveCarList();
		output.printCarInfo(carList);
	}

	// 차를 움직인다.
	private void moveCarList() {
		carList.forEach(car -> {
			car.move();
		});
	}

	//입력받은 이름으로 차를 생성한다
	private List<Car> makeCarList(String[] names) {
		List<Car> carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}
		return carList;
	}

}
