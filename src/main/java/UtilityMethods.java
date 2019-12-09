import domain.Car;

public class UtilityMethods {
	public static Car[] sliceString(String target) {
		String[] slicedString = target.split(",");
		Car[] cars = new Car[slicedString.length];

		for (int i = 0; i < slicedString.length; i++) {
			cars[i] = new Car(slicedString[i]);
		}

		return cars;
	}

	public static void playGameByNumber(int count, Car cars[]) {
		for (int i = 0; i < count; i++) {
			goForwardRandomly(cars);
			printGameResult(cars);
		}

	}

	public static void goForwardRandomly(Car[] cars) {
		double randomNumber = 0;

		for (Car car : cars) {
			randomNumber = Math.random();
			randomNumber = (int) (randomNumber * 10);
			if (randomNumber >= 4) {
				car.goForward();
			}
		}

	}

	private static void printGameResult(Car cars[]) {
		String gameResult = "";

		System.out.println("");
		for (Car car : cars) {
			String progress = "";
			for (int i = 0; i < car.getPosition(); i++) {
				progress += '-';
			}

			gameResult = car.getName() + " : " + progress;
			System.out.println(gameResult);
		}

	}
}
