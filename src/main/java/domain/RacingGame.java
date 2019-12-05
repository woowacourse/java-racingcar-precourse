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
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		input = scan.nextLine();
		carNames = input.split(",");
		
		
	}
	
}
