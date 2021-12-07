package racingcar.domain.result;

import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.exception.ImpossibleRacingException;

public class RacingResult {
	private static final int MIN_COUNT = 0;
	private final Cars cars;
	private int count;

	private RacingResult(int count, List<Car> cars) {
		validateRange(count);
		this.count = count;
		this.cars = Cars.of(cars);
	}

	public static RacingResult of(String count, Cars cars) {
		int countInt = intValue(count);
		return new RacingResult(countInt, cars.getCars());
	}

	private static int intValue(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 int 범위 내 0보다 큰 양의 정수여야 한다.");
		}
	}

	public void run() {
		try {
			validateEnd();
			cars.moveAll();
			count--;
		} catch (ImpossibleRacingException e) {
			e.printStackTrace();
		}
	}

	public String getPresentCarsStatus() {
		return cars.toString();
	}

	public String findFinalWinnerName() {
		validateProgressPossible();
		return cars.findWinnerName();
	}

	private void validateEnd() {
		if (isEnd()) {
			throw new ImpossibleRacingException("[ERROR] 시도 횟수가 소진되어 게임을 진행할 수 없습니다.");
		}
	}

	private void validateProgressPossible() {
		if (!isEnd()) {
			throw new ImpossibleRacingException("[ERROR] 시도 횟수만큼 게임이 진행되지 않으면 최종 우승자를 알 수 없습니다.");
		}
	}

	public boolean isEnd() {
		return count == MIN_COUNT;
	}

	private void validateRange(int count) {
		if (count <= MIN_COUNT) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 int 범위 내 0보다 큰 양의 정수여야 한다.");
		}
	}

}
