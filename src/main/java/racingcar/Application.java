package racingcar;

public class Application {
	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		inputManager.scanCars();
		inputManager.scanNumber();
	}
}
