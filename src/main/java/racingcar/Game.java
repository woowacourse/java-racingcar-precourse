package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final List<Car> carList;

	public Game() {
		this.carList = new ArrayList<>();
	}

	public void run() {
		System.out.println(Constant.START_GAME_MSG);
	}

}
