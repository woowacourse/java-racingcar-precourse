package domain;

public class Car {
	
	/* 0에서 9까지 랜덤 정수를 만들기 위한 상수 */
	private final static int RANGE = 10;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void goForwardOrNot() {
		if ((int) (Math.random() * RANGE) >= 4) {
			position++;
		}
	}

	public void showPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
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
