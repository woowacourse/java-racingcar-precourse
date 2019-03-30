package com.github.seokhyeonchoi.game.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
	private List<Car> cars;
	private int attemptNum;
	private static final Scanner scanner = new Scanner(System.in);
	
	public RacingCar() {
		cars = new ArrayList<>();
	}
	
	public void init() {
		String carNames = enterCarNames();
		enterAttempNum();
		
		addCarByCarNames(carNames);
	}
	
	public void start() {
		for(int i=0; i<attemptNum; i++) {
			moveAllCars();
			printAllCars();
		}
	}
	
	private String enterCarNames() {
		String carNames = "";
		
		while(carNames.equals("")) {
			System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분) ");
			carNames = scanner.nextLine();
		}
		
		return carNames;
	}
	
	private void enterAttempNum() {
		int attemptNumTemp = 0;
		
		while(attemptNumTemp < 1) {
			
			System.out.println("시도할 횟수는 몇 회 인가요?");
			attemptNumTemp = scanner.nextInt();
			
			if(attemptNumTemp < 1) {
				System.out.println("0 보다 큰 수를 입력해주세요.");
			}
		}
		attemptNum = attemptNumTemp;
	}
	
	private void addCarByCarNames(String carNames) {
		String[] carNameArray = carNames.split(",");
		
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
	}
}
