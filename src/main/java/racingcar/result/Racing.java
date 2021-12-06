package racingcar.result;

import racingcar.Cars;

public class Racing {
	private static final int MIN_COUNT = 0;
	private int count;
	private final Cars cars;

	private Racing(int count, Cars cars) {
		this.count = count;
		this.cars = cars;
	}

	public void start() {
		cars.moveAll();
		count--;
	}

	public boolean isEnd() {
		return count == MIN_COUNT;
	}

	public static Racing of(String count, Cars cars){
		int countInt = intValue(count);
		validateRange(countInt);
		return new Racing(countInt, cars);
	}

	private static void validateRange(int count) {
		if(count <= MIN_COUNT){
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 int 범위 내 0보다 큰 양의 정수여야 한다.");
		}
	}

	private static int intValue(String count){
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 int 범위 내 0보다 큰 양의 정수여야 한다.");
		}
	}

}
