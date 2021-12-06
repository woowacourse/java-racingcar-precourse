package racingcar;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		OutputHandler outputHandler = new OutputHandler();
		InputHandler inputHandler = new InputHandler(outputHandler);
		Judgement judgement = new Judgement();
		GameEngine gameEngine = new GameEngine(inputHandler, outputHandler, judgement);
		gameEngine.start();
	}
}
