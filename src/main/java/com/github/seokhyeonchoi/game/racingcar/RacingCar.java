package com.github.seokhyeonchoi.game.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
*
* @description : RacingCar Game Class
* @package : com.github.seokhyoenchoi.game.racingcar
* @author : 최석현
* 
*/
public class RacingCar {
	private List<Car> cars;
	private int attemptNum;
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public RacingCar() {
		cars = new ArrayList<>();
		init();
	}
	
	/**
	 * @desc Car List, 시도 횟수 초기화
	 */
	private void init() {
		String[] carNameArray = enterCarNames();
		enterAttempNum();
		
		addCarByCarNames(carNameArray);
	}
	
	/**
	 * @desc 시도 횟수만큼 move 및 중간상태 출력 후 결과 출력
	 */
	public void start() {
		System.out.println("실행 결과");
		
		for(int i=0; i<attemptNum; i++) {
			moveAllCars();
			printAllCars();
		}
		
		printResult();
	}
	
	/**
	 * @desc Car name들을 입력받고 검증 후 Array로 반환
	 */
	private String[] enterCarNames() {
		String[] carNameArray;
		
		while(true) {
			System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분) ");
			
			String carNames = SCANNER.nextLine();
			String[] nameArray = carNames.split(",");
			
			if(validNames(nameArray)) {
				carNameArray = nameArray;
				break;
			}
		}
		
		return carNameArray;
	}
	
	/**
	 * @desc 시도 횟수 검증 후 저장
	 */
	private void enterAttempNum() {
		int attemptNumTemp = 0;
		
		while(!validAttemptNum(attemptNumTemp)) {
			
			System.out.println("시도할 횟수는 몇 회 인가요?");
			attemptNumTemp = SCANNER.nextInt();
			
			if(!validAttemptNum(attemptNumTemp)) {
				System.out.println("0 보다 큰 수를 입력해주세요.");
			}
		}
		attemptNum = attemptNumTemp;
	}
	
	/**
	 * @desc Car 객체 생성 후 List에 추가
	 */
	private void addCarByCarNames(String[] carNameArray) {
		
		for(String carName : carNameArray) {
			String carNameTrimed = carName.trim();
			
			if(!carNameTrimed.equals("")){
				Car car = new Car(carNameTrimed);	
				cars.add(car);
			}
		}
	}
	
	
	private void moveAllCars() {
		for(Car car : cars) {
			car.move();
		}
	}
	
	private void printAllCars() {
		for(Car car : cars) {
			System.out.println(car);
		}
		System.out.println();
	}
	
	private void printResult() {
		int furthermostPosition = getFurthermostPosition();
		String printString = "";
		
		for(Car car : cars) {
			if(car.getPosition() == furthermostPosition) {
				printString += car.getName();
				printString += ", ";
			}
		}
		
		System.out.print(printString.substring(0, printString.length() - 2));
		System.out.println("가 최종 우승했습니다.");
	}
	
	/**
	 * @desc Car 중 가장 먼 거리 반환
	 */
	private int getFurthermostPosition() {
		int furthermostPosition = 0;
		
		for(Car car : cars) {
			int position = car.getPosition();
			if(position > furthermostPosition) {
				furthermostPosition = position;
			}
		}
		
		return furthermostPosition;
	}
	
	private boolean validAttemptNum(int num) {
		return (num > 0);
	}
	
	private boolean validNames(String[] names) {
		if(names.length < 1) {
			return false;
		}
		
		for(String name : names) {
			if(!name.trim().equals("")){
				return true;
			}
		}
		
		return false;
	}
}
