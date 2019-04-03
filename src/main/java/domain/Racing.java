/*
 * Racing 
 * 1.0.0
 * 2019.04.04
 */

package domain;

import java.util.Arrays;
import java.util.Random;

public class Racing {

	public static Car[] makeRacingCar(String names) {
		String[] name = names.split(",");
		Car[] result = new Car[name.length];
		for (int i = 0; i < name.length; i++) {
			result[i] = new Car(name[i]);
		}
		return result;
	}

	public static void winners(Car[] cars) {
		int[] distances = new int[cars.length];
		for (int i = 0; i < cars.length; i++) {
			distances[i] = cars[i].getPosition();
		}
		Arrays.sort(distances);
		String winnerIs = "";
		for (Car car : cars) {
			if (car.getPosition() == distances[distances.length - 1]) {
				winnerIs += car.getName() + " ";
			}
		}

		winnerIs = winnerIs.trim().replace(" ", ", ");
		System.out.println(winnerIs + "가 최종 우승했습니다.");
	}

	public static int makeRandInt() {
		return Racing.rand.nextInt(10);
	}

	public static void racing(Car car) {
		car.isGo(makeRandInt());
		System.out.println(car.getName() + ": " + "-".repeat(car.getPosition()));
	}

	private static Random rand = new Random(System.currentTimeMillis());
}
