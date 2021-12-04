package racingcar;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.start();
	}
}
