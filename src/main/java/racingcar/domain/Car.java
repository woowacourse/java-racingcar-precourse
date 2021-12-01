package racingcar.domain;

import static racingcar.constant.GameConstants.Car.*;
import static racingcar.constant.GameConstants.CarStringConversion.*;

import java.util.stream.IntStream;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

	public int getPosition() {
		return position;
	}

	public void moveByNumber(int randomNumber) {
		if (randomNumber >= MOVE_CRITERION_INCLUSIVE.getValue())
			this.position += 1;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name);
		stringBuilder.append(INFIX.getString());
		IntStream.range(0, position).forEach(i -> stringBuilder.append(GAUGE.getString()));
		return stringBuilder.toString();
	}
}
