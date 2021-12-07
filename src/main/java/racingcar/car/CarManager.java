package racingcar.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Number;
import racingcar.iomanagement.InputScanner;
import racingcar.iomanagement.Validator;

public class CarManager {
	InputScanner inputScanner = new InputScanner();

	private List<Car> generate(String carNames) {
		return Arrays.stream(carNames.split(","))
			.map(Validator::validateCarNameLengthUnderFive)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Car> generateWithException() {
		List<Car> carList;
		try {
			String carNames = inputScanner.enterCarName();
			carList = generate(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			carList = generateWithException();
		}
		return carList;
	}

	public List<Car> getWinner(List<Car> carList) {
		int maxPositionValue = getMaxPositionValue(carList);
		List<Car> winnerCarList = new ArrayList<>();

		carList.forEach(car -> {
			if (car.getPosition() == maxPositionValue) {
				winnerCarList.add(car);
			}
		});
		return winnerCarList;
	}

	private int getMaxPositionValue(List<Car> carList) {
		return Collections.max(carList
			.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList()));
	}

	public List<Car> updateCarListPosition(List<Car> carList) {
		return carList.stream()
			.map(this::updateCarRandom)
			.collect(Collectors.toList());
	}

	private Car updateCarRandom(Car car) {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= Number.MOVING_FORWARD) {
			car.updatePosition();
		}
		return car;
	}
}
