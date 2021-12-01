package racingcar;

public class Application {
	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		GameManager gameManager = new GameManager(inputManager);
		gameManager.startGame();
	}
}
