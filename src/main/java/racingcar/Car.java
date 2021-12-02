package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void forward() {
		position++;
	}

	@Override
	public String toString() {
		return name + " : " + progress(position);
	}

	private String progress(int position) {
		return IntStream.range(0, position).mapToObj(i -> "-").collect(Collectors.joining());
	}
}
