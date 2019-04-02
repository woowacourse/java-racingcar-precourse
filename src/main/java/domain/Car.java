/*
 * @(#)Car.java	1.8.0_191 2019/04/02
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */

package domain;

/*
 * 자동차의 기본정보 : 이름, 위치 
 * randomValueCreate: 랜덤난수 생성(1~9)
 * acceleratorAndbreak : 전진and멈춤에 따란 위치변화
 * printDistance : 현재까지 달려온 거리를 출력 
 * 
 * @author 손영배
 * 
 * */

public class Car {
	
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private int randomValueCreate() {

		int randomNumber = 0;

		while (true) {
			
			randomNumber = (int) (Math.random() * 10);
			
			if (randomNumber == 0)
				continue;
			
			return randomNumber;
		}
	}

	public void acceleratorAndbreak() {

		if (randomValueCreate() >= 4)
			this.position++;

	}

	public void printDistance() {

		System.out.print(this.name + ":");
		
		for (int i = 0; i < this.position; i++) {
			System.out.print("-");
		}
		
		System.out.println();
	} 

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}
