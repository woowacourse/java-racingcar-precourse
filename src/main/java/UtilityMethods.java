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

		for (int i = 0; i < cars.length; i++) {
			randomNumber = Math.random();
			randomNumber = (int) (randomNumber * 10);
			if (randomNumber >= 4) {
				cars[i].goForward();
			}

		}

	}

	private static void printGameResult(Car cars[]) {
		String gameResult = "";

		System.out.println("");
		for (int i = 0; i < cars.length; i++) {
			String progress = "";
			for (int j = 0; j < cars[i].getPosition(); j++) {
				progress += '-';
			}

			gameResult = cars[i].getName() + " : " + progress;
			System.out.println(gameResult);
		}

	}
}
