package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
	private static int triedCnt;
	private static List<Car> carList = new ArrayList<>();
	
	private static Player player = new Player();
	
	public void start(Scanner scanner) {		
		player.inputRacingCar(scanner);
		
		startRace();
	}
	
	public static void setCar(List<String> carNames) {
		for (String car : carNames) {
			carList.add(new Car(car));
		}
	}
	
	public static void setTriedCount(int cnt) {
		triedCnt = cnt;
	}
	
	public void startRace() {
		for (Car car : carList) {
			
		}
	}
}
