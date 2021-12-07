package racingcar.domain;

import java.util.Objects;

public class Car {
	private final String name;
	private int position = 0; // 생성자에서 따로 받지 않는 인스턴스변수는 선언시 초기화해줘야한다.

	public Car(String name) {
		this.name = name;
	}

	public static Car of(Name name) {
		return new Car(name.getName());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

}
