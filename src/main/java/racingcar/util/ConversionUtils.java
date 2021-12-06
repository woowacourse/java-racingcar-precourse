package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class ConversionUtils {
	public static List<Car> getCarListFromNameList(List<String> carNameList) {
		return carNameList.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
