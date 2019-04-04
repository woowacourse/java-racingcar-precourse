package domain;


public class RacingGame {
	private Car[] cars;
	private String[] arrCarNames;
	
	public RacingGame() {
		UserInput user = new UserInput();
		int numberOfAttemp;
		
		arrCarNames = user.setCarNames();
		setCarObject();
		printCarNames();
		
		numberOfAttemp = user.setNumberOfAttep();
	}
	
	private void setCarObject () {
		cars = new Car[arrCarNames.length];
		
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(arrCarNames[i]);
		}
	}
	
	private void printCarNames() {
		for (int i = 0; i < cars.length; i++) {
			System.out.print(cars[i].getName());
			
			if (i != cars.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new RacingGame();
	}
}
