package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		Validator.validateDuplicateCars(cars);
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public LinkedHashMap<Car, String> showCarsPosition() {
		LinkedHashMap<Car, String> roundResult = new LinkedHashMap<>();
		for (Car car : cars) {
			String carPosition = car.makeCarProgressSign(car.getPosition());
			roundResult.put(car, carPosition);
		}
		return roundResult;
	}

	public void playRound() {
		for (Car car : cars) {
			int random = Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
			car.proceed(random);
		}
	}
}
