package racingcar;

import static racingcar.Car.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;

public class Judge {

	public static List<String> judging(Car[] cars){
		List<Car> carList = Lists.list(cars);
		sortingByPosition(carList);

		return getCarPositionPerRace(carList);
	}

	private static List<String> getCarPositionPerRace(List<Car> carList) {
		int max = carList.get(0).getPosition();

		List<String> winnerList = new ArrayList<>();
 		for (Car car : carList) {
			if (max == car.getPosition()) {
				winnerList.add(car.getName());
			}
		}
		return winnerList;
	}
}
