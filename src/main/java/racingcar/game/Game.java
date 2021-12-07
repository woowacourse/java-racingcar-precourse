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
		String[] names = input.inputNames();
		carList = makeCarList(names);
		num = input.inputNum();
		System.out.println();

		umpire = new Umpire(carList);
		output = new Output();
	}

	public void start() {
		System.out.println(RESULT);
		for (int i = 0; i < num; i++) {
			playGames();
			System.out.println();
		}
	}

	public void end() {
		umpire.getWinner();
		output.printWinners(umpire.getWinnersNameList());
	}

	private void playGames() {
		moveCarList();
		output.printCarInfo(carList);
	}

	private void moveCarList() {
		carList.forEach(car -> {
			car.move();
		});
	}

	private List<Car> makeCarList(String[] names) {
		List<Car> carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}
		return carList;
	}

}
