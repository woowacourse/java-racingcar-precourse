package domain;

public class Process {
	
	public static void isCarProceed(Car currentCar) {
		int condition = (int) Math.floor(Math.random() * 10);
		if (condition > 3) {
			currentCar.addPosition();
		}
	}
	
	public static void printEachCarStatus(Car currentCar) {
		System.out.print(currentCar.getName() + " : ");
		for (int i = 0; i < currentCar.getPosition(); i++) {
			System.out.print('-');
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
	
	}
}
