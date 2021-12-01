package racingcar;

public class Application {
	public static boolean continueGame = true;
	public static String[] carsList;

	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		while (continueGame) {
			try {
				carsList = inputManager.scanCarsList();
				continueGame = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
