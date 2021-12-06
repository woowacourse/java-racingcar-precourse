package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
	public List<Car> generateCar(String carNames) {
		//TODO 차 입력 예외처리 및 유효성 검사 필요
		return Arrays.stream(carNames.split(","))
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
