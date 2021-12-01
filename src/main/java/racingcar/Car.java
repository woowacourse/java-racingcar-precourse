package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

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

	// public int getGameTurns() {
	// 	String input = readLine();
	//
	// 	return NoOfGame;
	// }

	public int getPosition() {
		return this.position;
	}

	public void forward() {
		this.position++;
	}
}
