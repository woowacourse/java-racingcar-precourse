package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarPower {
	private static final int POWER_MIN = 0;
	private static final int POWER_MAX = 9;
	private static final int CAN_MOVE_MIN = 4;

	private final int power;

	private CarPower(int power) {
		this.power = power;
	}

	public static CarPower createRandomPower() {
		int randomPower = Randoms.pickNumberInRange(POWER_MIN, POWER_MAX);
		return new CarPower(randomPower);
	}

	//쉬운 테스팅을 위한 protected 생성
	protected static CarPower createPower(int power) {
		return new CarPower(power);
	}

	public boolean canMove() {
		return power >= CAN_MOVE_MIN;
	}
}
