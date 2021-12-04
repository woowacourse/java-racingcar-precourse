package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		CarNameValidator.validate(name);
		this.name = name;
	}

	//편리한 테스팅을 위한 protected 생성자
	protected Car(String name, int position) {
		this(name);
		this.position = position;
	}

	public void moveOrStop(CarPower carPower) {
		if (carPower.canMove()) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public boolean isSamePosition(Car car) {
		return position == car.position;
	}

	//view에서 사용하기 위한 getter들
	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Car other) {
		return position - other.position;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !o.getClass().equals(Car.class)) {
			return false;
		}
		Car other = (Car)o;
		return name.equals(other.name) && position == other.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
