/*
 * RacingGame
 * v1.0
 * 2019.12.05
 */

package domain;

import java.util.Scanner;
import java.util.Random;

public class RacingGame {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input;
		String[] carNames;
		int numberOfAttempts;
		String[] winners;
		
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
		
		//winners = getNamesOfWinnersFrom
		
		
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
}
