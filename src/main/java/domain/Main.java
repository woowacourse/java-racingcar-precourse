/*
 * @(#)Main.java
 *
 * 버전 : 1.0
 *
 * 날짜 : 2019.12.10
 */
package domain;

public class Main {

	public static void main(String[] args) {
		Game game;
		game = new Game();
		game.startGame();
		game.startRace();
		game.resultRace();
	}
}

