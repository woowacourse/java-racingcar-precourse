package domain;

public class Process {
	
	public static void isCarProceed(Car currentCar) {
		int condition = (int) Math.floor(Math.random() * 10);
		if (condition > 3) {
			currentCar.addPosition();
		}
	}
	
	public static void main(String[] args) {
	
	}
}
