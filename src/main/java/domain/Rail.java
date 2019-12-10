package domain;

public class Rail {
	private Car car;
	private int railNo;

	public Rail(int railNo, String name) {
		car = new Car(name);
		this.railNo = railNo;
	}
}
