package racingcar.util;

public class Validation {

	static public boolean verifyCar(String cars) {
		String[] splitCar = cars.split(",");
		for (String car:
			 splitCar) {
			if (car.length() > 5) {
				return false;
			}
		}
		return true;
	}
}
