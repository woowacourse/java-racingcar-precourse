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

	public static void goForwardRandomly (Car[] cars) {
		double randomNumber = 0;

		for (int i = 0; i < cars.length; i++) {
			randomNumber = Math.random();
			randomNumber = (int)(randomNumber * 10);
			if (randomNumber >= 4) {
				cars[i].goForward();
			}
		}

	}
}
