/*
 * 레이싱 게임을 위한 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.08
 * 
 * @author Jung dahee
 */

package domain;

import java.util.Scanner;

public class RacingCarGame {
	
	Car cars[];
	String sCars[];
	int max;
	int gameCnt;
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		inputCars();
		setCars();
		inputGameCnt();
		runRace();
	}
	
	public void end() {
		getMax();
		getWinners();
	}
	
	private void inputCars() { 
		String s = "";
		
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			s = sc.nextLine();
		} while(!checkInputCars(s));
	}
	
	private void setCars() {
		cars = new Car[sCars.length];
		
		for(int i = 0; i < cars.length; i++) {
			cars[i] = new Car(sCars[i].trim());
		}
	}
	
	private void inputGameCnt() {
		String sCnt;
		
		do {
			System.out.println("시도할 회수는 몇회인가요?");
			sCnt = sc.nextLine();
		} while(!checkInputCnt(sCnt));
		
		gameCnt = Integer.parseInt(sCnt);
	}
	
	private void runRace() {
		System.out.println("\n실행 결과");
		
		while((gameCnt--) != 0) {
			moveCar();
		}
	}
	
	private void moveCar() {
		for(int i = 0; i < cars.length; i++) {
			if(getNum() >= 4) {
				cars[i].moveForward();
			}
			
			System.out.println(cars[i].getName() + ":" + 
					new String(new char[cars[i].getPosition()]).replace("\0", "-"));
		}
		System.out.println();
	}
	
	private int getNum() {
		double randomValue = Math.random();
		int num = (int) (randomValue * 9);
		
		return num;
	}
	
	private boolean checkInputCars(String str) {
		if(!checkNotNull(str)) {
			System.out.println("입력값이 없습니다. 다시 입력해주세요.");
			return false;
		}
		if(!checkLength(str)) {
			System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean checkNotNull(String str) {
		return str.length() != 0;
	}
	
	private boolean checkLength(String str) {
		sCars = str.split(",");
		
		for(int i = 0; i < sCars.length; i++) {
			String trimmedStr = sCars[i].trim();
			
			if(trimmedStr.length() == 0 || trimmedStr.length() > 5) {
				return false;
			}
		}
		return true;
	}
	

}
