package racingcar.game;

import static racingcar.utils.Notice.*;

import java.util.stream.IntStream;

import racingcar.car.Cars;
import racingcar.userinterface.Input;

public class Game {
	Input input = new Input();
	Cars cars = new Cars();

	public Game() {
		setCarList();
	}

	public void play() {
		System.out.println(INPUT_REPEAT_NUM);
		int repeatNum = input.getRepeatNum();
		Round round = new Round(cars.getList());
		IntStream.range(0, repeatNum).forEach(i -> round.run());
	}

	private void setCarList() {
		System.out.println(INPUT_CAR_NAMES);
		input.getCarNameList().forEach(cars::appendCar);
	}

	public void printWinner() {
		String winnerNames = String.join(", ", cars.getWinnerNameList());
		System.out.printf("최종 우승자 : %s\n", winnerNames);
	}
}
