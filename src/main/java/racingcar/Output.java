package racingcar;

import static racingcar.Car.*;

import java.util.List;

import org.assertj.core.util.Lists;

public class Output {

	public static void outputCarPosition(Car[] cars) {
		for (Car car : cars) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	public static void outputRaceResult(Car[] cars) {
		List<Car> carList = Lists.list(cars);
		sortingByPosition(carList);

		StringBuilder sb = new StringBuilder();
		System.out.println("실행 결과");

		int max = carList.get(0).getPosition();
		for (Car car : carList) {
			if (max == car.getPosition()) {
				sb.append(car.getName() + ", ");
			}
		}

		String result = sb.toString();
		System.out.println("최종 우승자 : " + result.substring(0, result.length() - 2));
	}

}
