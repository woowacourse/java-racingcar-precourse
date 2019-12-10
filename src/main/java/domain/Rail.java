package domain;

public class Rail {
	private Car car;
	private int railNo;

	public Rail(String name, int railNo) {
		car = new Car(name);
		this.railNo = railNo;
	}

	public Car getCar() {
		return car;
	}

	public int getRailNo() {
		return railNo;
	}
}
