/*
 * Main.java		2019/04/04
 * 
 * 이 프로그램은 누구든 수정 가능합니다
 */
package domain;

/**
 * 게임을 실행하는 클래스이다.
 * 
 * @version 1.00 2019/04/04
 * @author DiceMono
 */
public class Main {

	private static void playJavaRacingCar() {
		RacingStation racingStation = new RacingStation();
		racingStation.getCarArray();
		racingStation.startRace();
		racingStation.printWinners();
	}

	/* 게임이 실행되는 공간 */
	public static void main() {
		playJavaRacingCar();
	}
}