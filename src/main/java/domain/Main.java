package domain;

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
