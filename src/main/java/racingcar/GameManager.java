package racingcar;

import java.util.Scanner;

public class GameManager {
	
	GameManager() {}
	
	public void start(Scanner scanner) {
		Player player = new Player();
		
		player.inputRacingCar(scanner);
	}
}
