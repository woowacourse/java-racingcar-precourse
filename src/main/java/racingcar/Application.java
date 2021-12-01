package racingcar;

public class Application {
	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		GameManager gameManager = new GameManager(inputManager);
		gameManager.startGame();
		for (int i=0;i<gameManager.carsMoveCount.length;i++){
			System.out.println(gameManager.carsMoveCount[i]);
		}
	}
}
