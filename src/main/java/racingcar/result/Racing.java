package racingcar.result;

import java.util.List;

import racingcar.Car;
import racingcar.Cars;
import racingcar.exception.ImpossibleRacingException;

public class Racing {
	private static final int MIN_COUNT = 0;
	private final Cars cars;
	private int count;

	private Racing(int count, List<Car> cars) {
		validateRange(count);
		this.count = count;
		this.cars = Cars.of(cars);
	}

	public static Racing of(String count, Cars cars) {
		int countInt = intValue(count);
		return new Racing(countInt, cars.getCars());
	}

	private static int intValue(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 int 범위 내 0보다 큰 양의 정수여야 한다.");
		}
	}

	public void start() {
		try {
			validateEnd();
			cars.moveAll();
			count--;
		} catch (ImpossibleRacingException e) {
			e.printStackTrace();
		}
	}

	public String getPresentCarStatus() {
		return cars.toString();
	}

	public String getFinalWinnerName() {
		return cars.getFinalWinnerName();
	}

	private void validateEnd() {
		if (isEnd()) {
			throw new ImpossibleRacingException("[ERROR] 시도 횟수가 소진되어 게임을 진행할 수 없습니다.");
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
