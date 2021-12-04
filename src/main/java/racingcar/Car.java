package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		validateNameLength(name);
		validateBlankName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	// 추가 기능 구현
	public void validateNameLength(String name) {
		if (name.length() > Constant.NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(Constant.NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE);
		}
	}

	public void validateBlankName(String name){
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constant.NAME_MINIMUN_LENGTH_UNDER_ERROR_MESSAGE);
		}
	}

	public void proceed(int randomValue) {
		if (randomValue >= Constant.PROCEED_CRITERIA) {
			position++;
		}
	}

	public String makeCarProgressSign(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(Constant.CAR_PROGRESS_SIGN);
		}
		return stringBuilder.toString();
	}
}
