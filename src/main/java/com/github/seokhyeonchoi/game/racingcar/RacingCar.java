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
		enterAttempNum();
	}
	
	public void start() {
		
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
	
	private void moveAllCars() {
		
	}
	
	
}
