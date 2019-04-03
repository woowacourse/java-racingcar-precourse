/*
 * Car 
 * 1.0.0
 * 2019.04.04
 */

package domain;

import java.util.Scanner;

public class Car {
	private final String name;
	private int position = 0;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	public Car(String name) {
		this.name = name;
	}

	public boolean isGo(int val) {
		if (val >= 4) {
			this.position++;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Scanner stdIn = new Scanner(System.in);
		String names = stdIn.nextLine();
		System.out.println("시도할 회수는 몇 회인가요?");
		int cases = stdIn.nextInt();
		stdIn.close();
		
		Car[] cars = Racing.makeRacingCar(names);

		while (cases-- > 0) {
			for (int i = 0; i < cars.length; i++) {
				Racing.racing(cars[i]);
			}
			System.out.println();
		}

		Racing.winners(cars);

	}

	// 추가 기능 구현
}
