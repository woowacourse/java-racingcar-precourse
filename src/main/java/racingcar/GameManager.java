package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import utils.Validator;

public class GameManager {
	private static int triedCnt;
	private static List<Car> carList = new ArrayList<>();
	
	private static Player player = new Player();
	
	public void start(Scanner scanner) {		
		player.inputRacingCar(scanner);
		race();
		printRacingWinner();
	}
	
	public static void setCar(List<String> carNames) {
		for (String car : carNames) {
			carList.add(new Car(car));
		}
	}
	
	public static void setTriedCount(int cnt) {
		triedCnt = cnt;
	}
	
	private void race() {
		System.out.println("\n실행 결과");
		for (int i = 0; i < triedCnt; i++) {
			moveCar();
			System.out.println();
		}
	}
	
	private void moveCar() {
		for (Car car : carList) {
			if (Validator.isMovable()) {
				car.move();
			}
			printMovingResult(car);
		}
	}
	
	private void printMovingResult(Car car) {
		String movingDistance = "-".repeat(car.getPosition());
		System.out.println(car.getName() + " : " + movingDistance);
	}
	
	private void printRacingWinner() {
		int maxDistance = getMaxDistance();
		String winners = getWinners(maxDistance);
		
		System.out.println("최종 우승자: " + winners);
	}
	
	private int getMaxDistance() {
		List<Integer> distances = new ArrayList<>();
		
		for (Car car : carList) {
			distances.add(car.getPosition());
		}
		
		return Collections.max(distances);
	}
	
	private String getWinners(int maxDistance) {
		String winners = "";
		
		for (Car car : carList) {
			if (car.getPosition() == maxDistance) {
				winners += car.getName() + ", ";
			}
		}
		
		return winners.substring(0, winners.length() - 2);
	}
}
