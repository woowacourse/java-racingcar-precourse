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
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		input = scan.nextLine();
		carNames = input.split(",");
		
		Car[] Cars = GetCarInstancesFromCarNames(carNames);
		
	}
	
	public static Car[] GetCarInstancesFromCarNames(String[] carNames) {
		Car[] carInstances = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			carInstances[i] = new Car(carNames[i]);
		}
		return carInstances;
	}
}
