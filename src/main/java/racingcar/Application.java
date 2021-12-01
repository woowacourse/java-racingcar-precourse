package racingcar;

public class Application {
	public static boolean continueGame = true;
	public static String[] carsList;
	public static int numberOfMove;

	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		inputManager.scanCars();
		inputManager.scanNumber();
	}
}
