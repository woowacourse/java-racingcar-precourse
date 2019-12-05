/*
 * RacingGame
 * v1.0
 * 2019.12.05
 */

package domain;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class RacingGame {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input;
		String[] carNames;
		int numberOfAttempts;
		ArrayList<String> winners;
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		input = scan.nextLine();
		carNames = input.split(",");
		
		Car[] Cars = GetCarInstancesFromCarNames(carNames);
		
		System.out.println("시도할 회수는 몇회인가요?");
		numberOfAttempts = scan.nextInt();
		
		System.out.println("\n실행결과");
		for (int i = 0; i < numberOfAttempts; i++) {
			for (int j = 0; j < Cars.length; j++) {
				attempt(Cars[j]);
				printInformationOfCar(Cars[j]);	
			}
			System.out.println();
		}
		
		winners = getNamesOfWinnersFromCars(Cars);
		System.out.print(winners.get(0));
		for (int i = 1; i<winners.size(); i++) {
			System.out.print(", " + winners.get(i));
		}
		System.out.println("가 최종 우승했습니다.");
	}
	
	public static Car[] GetCarInstancesFromCarNames(String[] carNames) {
		Car[] carInstances = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			carInstances[i] = new Car(carNames[i]);
		}
		return carInstances;
	}
	
	public static void attempt(Car car) {
		boolean isProgress = progressOrNot();
		if (isProgress) {
			car.progressCar();
		}
	}
	
	public static boolean progressOrNot() {
		Random random = new Random();
		int randomInt = random.nextInt(10);
		if (randomInt >= 4) {
			return true;
		}		
		return false;		
	}
	
	public static void printInformationOfCar(Car car) {
		System.out.print(car.getName());
		System.out.print(" : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static ArrayList<String> getNamesOfWinnersFromCars(Car[] cars) {
		ArrayList<String> names = new ArrayList<String>();
		int longestPosition = 0;
		for (int i = 0; i < cars.length; i++) {
			if (longestPosition < cars[i].getPosition()) {
				longestPosition = cars[i].getPosition();
			}
		}
		
		for (int i = 0; i < cars.length; i++) {
			if (longestPosition == cars[i].getPosition()) {
				names.add(cars[i].getName());
			}
		}
		return names;
	}
}
