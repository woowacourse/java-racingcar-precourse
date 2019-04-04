package domain;


public class RacingGame {
	private Car[] cars;
	private String[] arrCarNames;
	
	public RacingGame() {
		UserInput user = new UserInput();
		
		arrCarNames = user.setCarNames();
		setCarObject();
	}
	
	private void setCarObject () {
		cars = new Car[arrCarNames.length];
		
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(arrCarNames[i]);
		}
	}
	
	public static void main(String[] args) {
		new RacingGame();
	}
}
