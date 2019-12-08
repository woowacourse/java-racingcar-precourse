package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void movePosition(int moveLength) {
		position += moveLength;
	}
	
	public void printCarStatus() {
		System.out.print(name+" : ");
		for(int i=0;i<position;i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
