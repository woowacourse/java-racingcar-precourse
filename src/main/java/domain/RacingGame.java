/*
 * RacingGame
 * 
 * version 1.0
 * 
 * 2019. 4. 2
 * 
 * Created by Wongeun Song
 */

package domain;

import java.util.Scanner;

public class RacingGame {
	public void play() {
		String carNameList = this.inputCarNameList();
	}
	
	public String inputCarNameList() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		return scan.nextLine();
	}
}
