package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.racing.domain.Car;
import racingcar.racing.domain.Cars;
import racingcar.type.DelimiterType;
import racingcar.type.RandomConditionType;
import racingcar.view.OutputView;

public class RacingController {

	public void run(List<String> carNames, int tryNumber) {
		Cars cars = getCarsFromNames(carNames);
		String result = playRacing(cars.getCars(), tryNumber);
		OutputView.printWinner(result);
	}

	private String playRacing(List<Car> cars, int tryNumber) {
		OutputView.printRacingResult();
		while (tryNumber-- > 0) {
			progressOneTime(cars);
			OutputView.printNewLine();
		}
		int maximumPosition = getMaxMovedPosition(cars);
		return getWinner(cars, maximumPosition);
	}

	private void progressOneTime(List<Car> cars) {
		for (Car car : cars) {
			tryMoveForward(car);
			OutputView.printCarStatus(car.getName(), getMovedDistance(car.getPosition()));
		}
	}

	private StringBuilder getMovedDistance(int position) {
		StringBuilder distance = new StringBuilder();
		for (int i = 0; i < position; i++) {
			distance.append(DelimiterType.DISTANCE.getDelimiter());
		}
		return distance;
	}

	private void tryMoveForward(Car car) {
		if (checkMovableCondition()) {
			car.moveForward();
		}

	}

	private Boolean checkMovableCondition() {
		int randomNumber =
			Randoms.pickNumberInRange(RandomConditionType.MIN_NUMBER_RANGE.getRandomCondition(),
				RandomConditionType.MAX_NUMBER_RANGE.getRandomCondition());
		return randomNumber <= RandomConditionType.MOVABLE_CONDITION_NUMBER.getRandomCondition();
	}

	private Cars getCarsFromNames(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return new Cars(cars);
	}

	private int getMaxMovedPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			int position = car.getPosition();
			if (maxPosition < position) {
				maxPosition = position;
			}
		}
		return maxPosition;
	}

	private String getWinner(List<Car> cars, int maxMovedPosition) {
		List<String> winner = cars.stream()
			.filter((car) -> car.getPosition() == maxMovedPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
		return String.join(DelimiterType.CAR_NAME_DELIMITER.getDelimiter() + " ", winner);
	}
}
