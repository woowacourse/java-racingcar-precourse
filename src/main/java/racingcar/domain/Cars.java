package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constant;
import racingcar.utils.Validator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		Validator.validateDuplicateCars(cars);
		this.cars = cars;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
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
