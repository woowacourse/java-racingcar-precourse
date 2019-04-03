/*
 * @(#) Main.java     1.0   2019/04/02
 *
 * Released under the MIT license
 */

import domain.GameUI;

/**
 * Main 클래스는 자동차경주게임 프로그램을 시작한다.
 *
 * @author 조남균
 * @version 1.00  2019년 04월 02일
 */
public class Main {
	public static void main(String[] args) {
		GameUI gameUI = new GameUI();

		gameUI.run();
	}
}