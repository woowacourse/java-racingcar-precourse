package racingcar;

import java.util.Optional;
import java.util.stream.Stream;

public class Car {
	private static final int FORWARD_THRESHOLD_NUMBER = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public static boolean isForward(int randNo) {
		return randNo >= FORWARD_THRESHOLD_NUMBER;
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	public void forward() {
		this.position++;
	}

	public String getScoreString() {
		String unit = "-";
		Optional<String> result1 = Optional.empty();
		for (int count = 0; count <= this.position; count++) {
			result1 = Stream.generate(() -> unit).limit(count).reduce((a, b) -> a + b);
		}
		String finalResult = "";
		if (result1.isPresent()) {
			finalResult = result1.get();
		}
		return finalResult;
	}
}
