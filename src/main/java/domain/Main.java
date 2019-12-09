/*
 * 레이싱 게임을 생성하고 종료시키는 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.08
 * 
 * @author Jung dahee
 */


package domain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RacingCarGame game = new RacingCarGame();
		game.start();
		game.end();
	}
}
