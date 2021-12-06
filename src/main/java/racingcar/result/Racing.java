package racingcar.result;

import racingcar.Cars;
import racingcar.exception.ImpossibleRacingException;

public class Racing {
	private static final int MIN_COUNT = 0;
	private int count;
	private final Cars cars;

	private Racing(int count, Cars cars) {
		this.count = count;
		this.cars = cars;
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

	public String getFinalWinnerName(){
		return cars.getFinalWinnerName();
	}

	private void validateEnd() {
		if(isEnd()){
			throw new ImpossibleRacingException("[ERROR] 시도 횟수가 소진되어 게임을 진행할 수 없습니다.");
		}
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
