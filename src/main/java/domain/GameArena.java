/*
 * GameArena.java
 */

package domain;

import java.util.List;

public class GameArena {

	public static void main(String[] args) {
		List<Car> carList = InputView.getCarsList();
		int gameCount = InputView.getGameCount();
		OutputView.printGame(carList, gameCount);
	}
}
