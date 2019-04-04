package domain;

import java.util.Random;
import java.lang.StringBuilder;

public class Car {
	private Random random = new Random();
	private StringBuilder stringPosition = new StringBuilder();
	private final String name;
	private int position = 0;
	
	public Car(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void tryMove() {
		int randomInt = random.nextInt(10);
		if(randomInt >= 4) {
			position++;
			stringPosition.append('-');
		}
		System.out.println(this.name + " : " + stringPosition);
	}
	
	/* 테스트 코드 */
	public static void main(String[] args) {
		Car pobi = new Car("pobi");
		Car crong = new Car("crong");
		
		for(int count = 0; count < 10; count++) {
			pobi.tryMove();
			crong.tryMove();
			System.out.println();
		}
	}
}
