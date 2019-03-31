/*
 * OutputView.java
 */

package domain;

import java.util.List;

class OutputView {

	public static void printGame(List<Car> carList, int gameCount) {
		System.out.println("실행 결과");
		GameRound gameRound = new GameRound(carList);
		printGameRounds(gameRound, gameCount);
		printResult(gameRound);
	}

	private static void printGameRounds(GameRound gameRound, int gameCount) {
		for (int i = 0; i < gameCount; i++) {
			gameRound.proceed();
			gameRound.printGameRounds();
			System.out.println();
		}
	}

	private static void printResult(GameRound finalRound) {
		System.out.println(finalRound.getWinnerString() + "가 우승했습니다");
	}

}
