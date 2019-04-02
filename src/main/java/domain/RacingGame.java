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
import java.util.Vector;

public class RacingGame {
	Vector<Car> Cars = new Vector<Car>();
	
	public void play() {
		String carNameList = this.inputCarNameList();
		String[] carNameArray = this.parseCarNameList(carNameList);
		
		this.makeCars(carNameArray);
		this.moveCars();
	}
	
	private String inputCarNameList() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		return scan.nextLine();
	}
	
	private String[] parseCarNameList(String carNameList) {
		return carNameList.split(",");
	}
	
	private void makeCars(String[] carNameArray) {
		for (int i = 0; i < carNameArray.length; i++) {
			Cars.add(new Car(carNameArray[i]));
		}
	}
	
	private void moveCars() {
		Car car;
		
		for (int i = 0; i < Cars.size(); i++) {
			car = Cars.elementAt(i);
			car.move();
			car.printPosition();
		}
	}
}
