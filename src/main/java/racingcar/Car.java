package racingcar;

public class Car implements Comparable {

	private static final String NAMING_ERROR_MESSAGE = "길이는 5글자 이내로 입력해야 합니다.";
	private static final int LENGTH_LIMIT = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validateName(name);
		this.name = name;
	}

	public String getCarName() {
		return this.name;
	}

	public int getLocation() {
		return this.position;
	}

	private void validateName(String name) {
		if (name.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException(NAMING_ERROR_MESSAGE);
		}
	}

	public void moveCar(int distance) {
		this.position += distance;
	}

	@Override
	public int compareTo(Object object) {
		Car other = (Car)object;
		if (this.getLocation() < other.getLocation()) {
			return -1;
		}
		return 1;
	}
}
