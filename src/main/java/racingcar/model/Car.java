package racingcar.model;

public class Car implements Comparable<Car> {
	private static final String NAME_ERROR_MESSAGE = "자동차의 이름은 1~5자여야 한다.";

	private final String name;
	private int position = 0;

	public Car(String name) throws IllegalArgumentException {
		validateName(name);
		this.name = name;
	}

	private static void validateName(String name) throws IllegalArgumentException {
		if (name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
		}
	}

	public void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public int compareTo(Car car) {
		return (position - car.getPosition()) * -1;
	}
}
